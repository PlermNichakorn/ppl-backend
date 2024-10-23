package se331.project2.rest.security.auth;



import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se331.project2.rest.security.config.JwtService;
import se331.project2.rest.security.token.Token;
import se331.project2.rest.security.token.TokenRepository;
import se331.project2.rest.security.token.TokenType;
import se331.project2.rest.security.user.Role;
import se331.project2.rest.security.user.User;
import se331.project2.rest.security.user.UserRepository;
import se331.project2.rest.util.LabMapper;
import se331.project2.rest.entity.Country;
import se331.project2.rest.entity.CountryAuthDTO;
import se331.project2.rest.repository.CountryRepository;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final CountryRepository countryRepository;

  public AuthenticationResponse register(RegisterRequest request) {
    User savedUser;
    String jwtToken = null;
    String refreshToken = null;
    User user = null;
    Country country1;
    try {
      Country country = Country.builder()
              .countryName(request.getUsername())
              .id(countryRepository.count() + 1)
              .build();
      user = User.builder()
              .firstname(request.getFirstname())
              .enabled(true)
              .lastname(request.getLastname())
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              .username(request.getUsername())
              .country(country)
              .roles(List.of(Role.ROLE_DISTRIBUTOR))
              .build();
      country1 = countryRepository.save(country);
      savedUser = repository.save(user);
      country1.setUser(user);
      jwtToken = jwtService.generateToken(user);
      refreshToken = jwtService.generateRefreshToken(user);
      saveUserToken(savedUser, jwtToken);
    } catch (Exception e) {
      System.out.print(e);
    }
    // Manually create OrganizerAuthDTO
    CountryAuthDTO countryAuthDTO = CountryAuthDTO.builder()
            .id(user.getCountry().getId())
            .countryName(user.getCountry().getCountryName())
            .roles(user.getRoles()) // Set the roles here
            .build();
    return AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .refreshToken(refreshToken)
            .user(countryAuthDTO)
            .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            )
    );
    User user = repository.findByUsername(request.getUsername())
            .orElseThrow();

    String jwtToken = jwtService.generateToken(user);
    String refreshToken = jwtService.generateRefreshToken(user);
//    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .refreshToken(refreshToken)
            .user(LabMapper.INSTANCE.getCountryAuthDto(user.getCountry()))
            .build();
  }

  private void saveUserToken(User user, String jwtToken) {
    Token token = Token.builder()
            .user(user)
            .token(jwtToken)
            .tokenType(TokenType.BEARER)
            .expired(false)
            .revoked(false)
            .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
      User user = this.repository.findByUsername(userEmail)
              .orElseThrow();
      if (jwtService.isTokenValid(refreshToken, user)) {
        String accessToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        AuthenticationResponse authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
}

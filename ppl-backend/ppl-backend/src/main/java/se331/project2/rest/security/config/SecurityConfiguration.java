package se331.project2.rest.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.headers((headers) -> {
      headers.frameOptions((frameOptions) -> frameOptions.disable());
    });
    http
            .csrf((crsf) -> crsf.disable())
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests((authorize) -> {
              authorize.requestMatchers("/api/v1/auth/**").permitAll()
                      .requestMatchers(HttpMethod.GET,"/countries").permitAll()
                      .requestMatchers(HttpMethod.GET,"/countries/{id}").permitAll()
                      .requestMatchers(HttpMethod.GET,"/add-data").permitAll()
                      .requestMatchers(HttpMethod.GET,"/sports").permitAll()
                      .requestMatchers(HttpMethod.GET,"/sports/{id}").permitAll()
                      .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                      .requestMatchers(HttpMethod.POST, "/addCountries").hasRole("ADMIN")
                      .requestMatchers(HttpMethod.POST, "/imageUpload").permitAll()
                      .requestMatchers(HttpMethod.POST, "/sports").permitAll()
                      .anyRequest().authenticated();
            })

            .sessionManagement((session) ->{
              session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            })


            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .logout((logout) -> {
              logout.logoutUrl("/api/v1/auth/logout");
              logout.addLogoutHandler(logoutHandler);
              logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
            })
    ;

    return http.build();

  }
}
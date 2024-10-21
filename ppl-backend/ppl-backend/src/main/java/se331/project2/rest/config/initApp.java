package se331.project2.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.project2.rest.entity.Country;
import se331.project2.rest.entity.MedalCountsDTO;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.entity.SportDTO;
import se331.project2.rest.repository.CountryRepository;
import se331.project2.rest.repository.SportRepository;
import jakarta.transaction.Transactional;
import se331.project2.rest.security.user.Role;
import se331.project2.rest.security.user.User;
import se331.project2.rest.security.user.UserRepository;

@Component
@RequiredArgsConstructor
public class initApp implements ApplicationListener<ApplicationReadyEvent> {
    final CountryRepository countryRepository;
    final SportRepository sportRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        Country country1, country2, country3, country4, country5;
        country1 = countryRepository.save(Country.builder()
                .countryName("ABC")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .build());
        country2 = countryRepository.save(Country.builder()
                .countryName("DEF")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
//                .gold(40L)
//                .silver(44L)
//                .bronze(42L)
//                .rankValue(1L)
//                .sport("Basketball")
                .build());
        country3 = countryRepository.save(Country.builder()
                .countryName("GHT")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
//                .gold(40L)
//                .silver(44L)
//                .bronze(42L)
//                .rankValue(1L)
//                .sport("Basketball")
                .build());
        country4 = countryRepository.save(Country.builder()
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
//                .gold(40L)
//                .silver(44L)
//                .bronze(42L)
//                .rankValue(1L)
//                .sport("Basketball")
                .build());
        country5 = countryRepository.save(Country.builder()
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
//                .gold(40L)
//                .silver(44L)
//                .bronze(42L)
//                .rankValue(1L)
//                .sport("Basketball")
                .build());

        //Sport
        sportRepository.save(Sport.builder()
                .sportName("Basketball")
                .gold_medals(25)
                .silver_medals(10)
                .bronze_medals(21)
                .country(country1)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("Swimming")
                .gold_medals(10)
                .silver_medals(12)
                .bronze_medals(13)
                .country(country1)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("Volleyball")
                .gold_medals(5)
                .silver_medals(22)
                .bronze_medals(8)
                .country(country2)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("Soccer")
                .gold_medals(25)
                .silver_medals(10)
                .bronze_medals(21)
                .country(country2)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("Ballet")
                .gold_medals(10)
                .silver_medals(12)
                .bronze_medals(13)
                .country(country3)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("Synchronized swimming")
                .gold_medals(5)
                .silver_medals(22)
                .bronze_medals(8)
                .country(country3)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("ฺBoxing")
                .gold_medals(20)
                .silver_medals(15)
                .bronze_medals(24)
                .country(country4)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("Running")
                .gold_medals(9)
                .silver_medals(11)
                .bronze_medals(12)
                .country(country4)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("Judo")
                .gold_medals(6)
                .silver_medals(23)
                .bronze_medals(10)
                .country(country5)
                .build());
        sportRepository.save(Sport.builder()
                .sportName("Badminton")
                .gold_medals(20)
                .silver_medals(15)
                .bronze_medals(5)
                .country(country5)
                .build());
        addUser();
        country1.setUser(user1);
        user1.setCountry(country1);
        country2.setUser(user2);
        user2.setCountry(country2);
        
    }
    User user1,user2;
    private void addUser(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("ppg")
                .password(encoder.encode("ppg1234"))
                .firstname("ppg")
                .lastname("admin")
                .email("ppg@gmail.com")
                .enabled(true)
                .build();
        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .build();
        user1.getRoles().add(Role.ROLE_USER);
        user1.getRoles().add(Role.ROLE_ADMIN);
        user2.getRoles().add(Role.ROLE_USER);
        userRepository.save(user1);
        userRepository.save(user2);
    }


}

package se331.project2.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.project2.rest.entity.Country;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.repository.CountryRepository;
import se331.project2.rest.repository.SportRepository;

@Component
@RequiredArgsConstructor
public class initApp implements ApplicationListener<ApplicationReadyEvent> {
    final CountryRepository countryRepository;
    final SportRepository sportRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        countryRepository.save(Country.builder()
                .countryName("ABC")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rankValue(1L)
                .sport("Basketball")
                .build());
        countryRepository.save(Country.builder()
                .countryName("DEF")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rankValue(1L)
                .sport("Basketball")
                .build());
        countryRepository.save(Country.builder()
                .countryName("GHT")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rankValue(1L)
                .sport("Basketball")
                .build());
        countryRepository.save(Country.builder()
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rankValue(1L)
                .sport("Basketball")
                .build());
        countryRepository.save(Country.builder()
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rankValue(1L)
                .sport("Basketball")
                .build());

        sportRepository.save(Sport.builder()
                .sportName("Basketball")
                .gold_medals(25L)
                .silver_medals(10L)
                .bronze_medals(21L)
                .build());
        sportRepository.save(Sport.builder()
                .id(002L)
                .sportName("Swimming")
                .gold_medals(10L)
                .silver_medals(12L)
                .bronze_medals(13L)
                .build());
        sportRepository.save(Sport.builder()
                .id(003L)
                .sportName("Volleyball")
                .gold_medals(5L)
                .silver_medals(22L)
                .bronze_medals(8L)
                .build());
    }

}

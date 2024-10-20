package se331.project2.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.project2.rest.entity.Country;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.repository.CountryRepository;
import se331.project2.rest.repository.SportRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class initApp implements ApplicationListener<ApplicationReadyEvent> {

    final CountryRepository countryRepository;
    final SportRepository sportRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
//        Sport sport1, sport2, sport3;
//        sport1 = sportRepository.save(Sport.builder()
//                        .sportName("Basketball").build());
//        sport2 = sportRepository.save(Sport.builder()
//                .sportName("Swimming").build());
//        sport3 = sportRepository.save(Sport.builder()
//                .sportName("Volleyball").build());
//        Country tempCountry;
//        tempCountry = countryRepository.save(Country.builder()
//                .countryName("United States")
//                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals .")
//                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
//                //.gold(40L)
//                //.silver(44L)
//                //.bronze(42L)
//                //.rankValue(1L)
//                //.sport("Basketball")
//                .build());
////        tempCountry.getCountrySports().addAll(List.of(sport1, sport2))
////        sport1.getCountrySports().add(tempCountry);
//
//
//        countryRepository.save(Country.builder()
//                .countryName("China")
//                .description("China first participated in the 1924 Summer Olympics under the name of the Republic of China (ROC) until the 1976 Winter Olympics, when it changed its name to the People's .")
//                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/270px-Flag_of_the_People%27s_Republic_of_China.svg.png")
////                .gold(40L)
////                .silver(27L)
////                .bronze(24L)
////                .rankValue(2L)
////                .sport("Basketball")
//                .build());
//        countryRepository.save(Country.builder()
//                .countryName("Japan")
//                .description("Japan first participated in the Olympics in 1912.")
//                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flag_of_Japan.svg/270px-Flag_of_Japan.svg.png")
////                .gold(20L)
////                .silver(12L)
////                .bronze(13L)
////                .rankValue(3L)
////                .sport("Basketball")
//                .build());
//        countryRepository.save(Country.builder()
//                .countryName("Australia")
//                .description("Australia has sent athletes to every Summer Olympic Games, as well as every Winter Olympics except 1924–32 and 1948. In 1908 and 1912 Australia.")
//                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Flag_of_Australia.svg/270px-Flag_of_Australia.svg.png")
////                .gold(18L)
////                .silver(19L)
////                .bronze(16L)
////                .rankValue(4L)
////                .sport("Basketball")
//                .build());
//        countryRepository.save(Country.builder()
//                .countryName("France")
//                .description("The modern Olympic Games were founded by French historian Pierre de Coubertin. France has competed in every edition (both Summer and Winter).")
//                .image("https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/330px-Flag_of_France.svg.png")
////                .gold(16L)
////                .silver(26L)
////                .bronze(22L)
////                .rankValue(5L)
////                .sport("Basketball")
//                .build());
//        countryRepository.save(Country.builder()
//                .countryName("Netherland")
//                .description("The Netherlands first sent athletes to the Olympic Games in 1900, and has participated in almost all Games since then with the exception of 1904 Summer Olympics.")
//                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Flag_of_the_Netherlands.svg/330px-Flag_of_the_Netherlands.svg.png")
////                .gold(15L)
////                .silver(7L)
////                .bronze(12L)
////                .rankValue(6L)
////                .sport("Basketball")
//                .build());
//        countryRepository.save(Country.builder()
//                .countryName("Thailand")
//                .description("Kingdom of Thailand first participated at the Olympic Games in 1952, and has sent athletes to compete in every Summer Olympic Games.")
//                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Flag_of_Thailand.svg/330px-Flag_of_Thailand.svg.png")
////                .gold(14L)
////                .silver(10L)
////                .bronze(8L)
////                .rankValue(7L)
////                .sport("Basketball")
//                .build());
//        countryRepository.save(Country.builder()
//                .countryName("South Korea")
//                .description("The Republic of Korea (commonly known as South Korea) first participated at the Olympic Games in 1948, and has sent athletes to compete in every Summer Olympic Games.")
//                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Flag_of_South_Korea.svg/330px-Flag_of_South_Korea.svg.png")
////                .gold(13L)
////                .silver(9L)
////                .bronze(10L)
////                .rankValue(8L)
////                .sport("Basketball")
//                .build());
//        countryRepository.save(Country.builder()
//                .countryName("Germany")
//                .description("Athletes from Germany have taken part in most of the modern Olympic Games held since 1896. Germany has hosted three Olympic Games, in 1936 .")
//                .image("https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/330px-Flag_of_Germany.svg.png")
////                .gold(12L)
////                .silver(13L)
////                .bronze(8L)
////                .rankValue(9L)
////                .sport("Basketball")
//                .build());
//        countryRepository.save(Country.builder()
//                .countryName("Italy")
//                .description("Italy has sent athletes to most of the modern Olympic Games held since 1896, outside of not having officially participated (as a national delegation) in the 1904 Summer Olympics")
//                .image("https://upload.wikimedia.org/wikipedia/en/thumb/0/03/Flag_of_Italy.svg/330px-Flag_of_Italy.svg.png")
//                //.gold(11L)
//                //.silver(13L)
//                //.bronze(15L)
//                //.rankValue(10L)
//                //.sport("Basketball")
//                .build());
//        sportRepository.save(Sport.builder()
//                .sportName("Basketball")
////                .gold_medals(25L)
////                .silver_medals(10L)
////                .bronze_medals(21L)
//                .build());
//        sportRepository.save(Sport.builder()
//                .id(002L)
//                .sportName("Swimming")
////                .gold_medals(10L)
////                .silver_medals(12L)
////                .bronze_medals(13L)
//                .build());
//        sportRepository.save(Sport.builder()
//                .id(003L)
//                .sportName("Volleyball")
////                .gold_medals(5L)
////                .silver_medals(22L)
////                .bronze_medals(8L)
//                .build());
    }

}

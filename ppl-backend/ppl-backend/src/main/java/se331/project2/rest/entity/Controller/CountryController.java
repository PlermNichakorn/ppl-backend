package se331.project2.rest.entity.Controller;

import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se331.project2.rest.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryController {
    List<Country> countryList;

    @PostConstruct
    public void init() {
        countryList.add(Country.builder()
                        .id(110L)
                        .countryName("United States")
                        .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rank(1L)
                .sport("Basketball")
                .build());
        countryList.add(Country.builder()
                .id(110L)
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rank(1L)
                .sport("Basketball")
                .build());
        countryList.add(Country.builder()
                .id(110L)
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rank(1L)
                .sport("Basketball")
                .build());
        countryList.add(Country.builder()
                .id(110L)
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rank(1L)
                .sport("Basketball")
                .build());
        countryList.add(Country.builder()
                .id(110L)
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rank(1L)
                .sport("Basketball")
                .build());
        countryList.add(Country.builder()
                .id(110L)
                .countryName("United States")
                .description("The United States first participated in the Olympics in the 1896 Summer Olympics and has sent athletes to every Summer Olympics since. Athletes have won a total of 2,826 medals: 1,125 gold, 907 silver, and 794 bronze.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/330px-Flag_of_the_United_States.svg.png")
                .gold(40L)
                .silver(44L)
                .bronze(42L)
                .rank(1L)
                .sport("Basketball")
                .build());
    }
    @GetMapping("countries")
    public ResponseEntity<?> getCountryLists(@RequestParam(value = "_limit",required = false)Integer perPage, @RequestParam(value = "_page",required = false)Integer page){
        perPage = perPage == null?countryList.size():perPage;
        page = page == null?1:page;
        Integer firstIndex = (page-1)*perPage;
        List<Country> output = new ArrayList<>();
        for(int i = firstIndex; i < firstIndex+perPage; i++){
            output.add(countryList.get(i));
        }

        return ResponseEntity.ok(output);
    }
}

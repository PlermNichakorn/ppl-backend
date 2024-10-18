package se331.project2.rest.entity.Controller;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.project2.rest.entity.Country;

import java.util.ArrayList;
import java.util.List;
@Controller
public class CountryController {
    List<Country> countryList;


    @PostConstruct
    public void init() {
        countryList = new ArrayList<>();
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
                .id(111L)
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
                .id(112L)
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
                .id(113L)
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
                .id(114L)
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
                .id(115L)
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
    public ResponseEntity<?> getCountryLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page) {
        perPage = perPage == null ? countryList.size() : perPage;
        page = page == null ? 1 : page;
        Integer firstIndex = (page - 1) * perPage;
        List<Country> output = new ArrayList<>();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(countryList.size()));

        try {
            for (int i = firstIndex; i < firstIndex + perPage && i < countryList.size(); i++) {
                output.add(countryList.get(i));
            }
            return ResponseEntity.ok(output);
        } catch (IndexOutOfBoundsException ex) {
            return new ResponseEntity<>(output,responseHeader,HttpStatus.OK); // Return what we have even if it's not a full page
        }
    }

    @GetMapping("countries/{id}")
        public ResponseEntity<?> getCountry(@PathVariable("id") Long id) {
            Country output = null;
            for (Country country : countryList) {
                if (country.getId().equals(id)) {
                    output = country;
                    break;
                }
            }
            if (output != null){
                return ResponseEntity.ok(output);
            }else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
            }
        }
    }



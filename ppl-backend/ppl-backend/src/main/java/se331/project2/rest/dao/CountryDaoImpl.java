package se331.project2.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.project2.rest.entity.Country;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class CountryDaoImpl implements CountryDao {
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

    @Override
    public Integer getCountrySize(){
        return countryList.size();
    }
   @Override
    public List<Country> getCountries(Integer pageSize, Integer page) {
        int firstIndex = (page - 1) * pageSize;
        return countryList.subList(firstIndex, firstIndex + pageSize);
    }
    @Override
    public Country getCountry(Long id){
        return countryList.stream().filter(country ->
                country.getId().equals(id)).findFirst().orElse(null);
    }
}

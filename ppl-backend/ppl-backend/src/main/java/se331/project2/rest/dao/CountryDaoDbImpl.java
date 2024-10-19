package se331.project2.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.project2.rest.entity.Country;
import se331.project2.rest.repository.CountryRepository;

import java.util.List;

@Repository
@Profile("db")
@RequiredArgsConstructor
public class CountryDaoDbImpl implements CountryDao{
final CountryRepository countryRepository;
    @Override
    public Integer getCountrySize(){
        return Math.toIntExact(countryRepository.count());
    }

    @Override
    public List<Country> getCountries(Integer pageSize, Integer page){
        List<Country> countries = countryRepository.findAll();
        pageSize = pageSize == null ? countries.size():pageSize;
        page = page == null?1:page;
        int firstIndex = (page-1)*pageSize;
        List<Country> output = countries.subList(firstIndex, firstIndex+pageSize);
        return output;
    }

    @Override
    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }
}

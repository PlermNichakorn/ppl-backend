package se331.project2.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<Country> getCountries(Integer pageSize, Integer page){
        return countryRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country save(Country country){
        return countryRepository.save(country);
    }
}

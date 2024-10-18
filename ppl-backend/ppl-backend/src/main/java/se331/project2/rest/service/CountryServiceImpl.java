package se331.project2.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.project2.rest.dao.CountryDao;
import se331.project2.rest.entity.Country;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements Countryservice {
    final CountryDao countryDao;

    @Override
    public Integer getCountrySize(){
        return countryDao.getCountrySize();
    }

    @Override
    public List<Country> getCountries(Integer pageSize, Integer page){
        return countryDao.getCountries(pageSize, page);
    }

    @Override
    public Country getCountry(Long id){
        return countryDao.getCountry(id);
    }
}

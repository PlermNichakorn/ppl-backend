package se331.project2.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.project2.rest.dao.CountryDao;
import se331.project2.rest.entity.Country;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    final CountryDao countryDao;


    @Override
    public Integer getCountrySize(){
        return countryDao.getCountrySize();
    }

    @Override
    public Page<Country> getCountries(Integer pageSize, Integer page){
        if (page == null || page < 1) {
            page = 1; // default to first page
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10; // default page size
        }
        return countryDao.getCountries(pageSize, page);
    }

    @Override
    public Country getCountry(Long id){
        return countryDao.getCountry(id);
    }

    @Override
    public Country save(Country country){
        return countryDao.save(country);
    }
}

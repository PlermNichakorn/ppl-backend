package se331.project2.rest.service;

import org.springframework.data.domain.Page;
import se331.project2.rest.entity.Country;

import java.util.List;

public interface CountryService {
    Integer getCountrySize();
    Page<Country> getCountries(Integer pageSize, Integer page);
    Country getCountry(Long id);
}

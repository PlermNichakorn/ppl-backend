package se331.project2.rest.dao;

import se331.project2.rest.entity.Country;

import java.util.List;

public interface CountryDao{
    Integer getCountrySize();
    List<Country> getCountries(Integer pageSize, Integer page);
    Country getCountry(Long id);
}

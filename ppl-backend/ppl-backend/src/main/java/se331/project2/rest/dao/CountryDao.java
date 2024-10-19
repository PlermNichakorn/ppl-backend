package se331.project2.rest.dao;
import org.springframework.data.domain.Page;
import se331.project2.rest.entity.Country;
import java.util.List;

public interface CountryDao{
    Integer getCountrySize();
    Page<Country> getCountries(Integer pageSize, Integer page);
    Country getCountry(Long id);
}

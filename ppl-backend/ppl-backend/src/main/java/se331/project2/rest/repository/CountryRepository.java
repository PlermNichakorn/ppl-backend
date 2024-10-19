package se331.project2.rest.repository;

import org.springframework.data.repository.CrudRepository;
import se331.project2.rest.entity.Country;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country,Long> {
    List<Country> findAll();
}

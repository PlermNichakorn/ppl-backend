package se331.project2.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project2.rest.entity.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {
    List<Country> findAll();
}

package se331.project2.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se331.project2.rest.entity.Country;
import se331.project2.rest.entity.Sport;

import java.util.Arrays;
import java.util.List;

public interface SportRepository extends JpaRepository<Sport,Long> {
    List<Sport> findAll();

    @Query("SELECT SUM(cs.gold_medals), SUM(cs.silver_medals), SUM(cs.bronze_medals) FROM Sport cs WHERE cs.country.id = :countryId")
    Object[] findMedalCountsByCountryId(@Param("countryId") Long countryId);
}

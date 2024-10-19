package se331.project2.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se331.project2.rest.entity.Country;
import se331.project2.rest.entity.Sport;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport,Long> {
    List<Sport> findAll();
}

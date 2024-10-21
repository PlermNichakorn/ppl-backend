package se331.project2.rest.dao;

import org.springframework.data.domain.Page;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.entity.SportDTO;

public interface SportDao {
    Integer getSportSize();
    Page<Sport> getSports(Integer pageSize, Integer page);
    Sport getSport(Long id);
    Sport save(Sport sport);


}

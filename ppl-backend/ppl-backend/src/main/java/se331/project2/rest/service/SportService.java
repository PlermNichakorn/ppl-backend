package se331.project2.rest.service;

import org.springframework.data.domain.Page;
import se331.project2.rest.entity.MedalCountsDTO;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.entity.SportDTO;

public interface SportService {

    Integer getSportSize();
    Page<Sport> getSports(Integer pageSize, Integer page);
    Sport getSport(Long id);
    Sport save(Sport sport);


}

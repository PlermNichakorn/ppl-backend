package se331.project2.rest.service;

import org.springframework.data.domain.Page;
import se331.project2.rest.entity.Sport;

import java.util.List;

public interface SportService {
    Integer getSportSize();
    Page<Sport> getSports(Integer pageSize, Integer page);
    Sport getSport(Long id);
    Sport save(Sport sport);
}

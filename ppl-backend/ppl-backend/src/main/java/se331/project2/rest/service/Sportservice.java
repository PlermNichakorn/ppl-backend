package se331.project2.rest.service;

import se331.project2.rest.entity.Sport;

import java.util.List;

public interface Sportservice {
    Integer getSportSize();
    List<Sport> getSports(Integer pageSize, Integer page);
    Sport getSport(Long id);
}

package se331.project2.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.entity.SportDTO;
import se331.project2.rest.repository.SportRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class SportDaoDbImpl implements SportDao{
    final SportRepository sportRepository;

    @Override
    public Integer getSportSize() {
        return Math.toIntExact(sportRepository.count());
    }

    @Override
    public Page<Sport> getSports(Integer pageSize, Integer page) {
        return sportRepository.findAll(PageRequest.of(page-1, pageSize));
    }

    @Override
    public Sport getSport(Long id) {
        return sportRepository.findById(id).orElse(null);
    }
    @Override
    public Sport save(Sport sport){
        return sportRepository.save(sport);
    }


}

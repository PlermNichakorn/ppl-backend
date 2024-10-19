package se331.project2.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.project2.rest.dao.SportDao;
import se331.project2.rest.entity.Sport;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportServicelmpl implements SportService {
    final SportDao sportDao;

    @Override
    public Integer getSportSize(){
        return sportDao.getSportSize();
    }

    @Override
    public Page<Sport> getSports(Integer pageSize, Integer page){
        if (page == null || page < 1) {
            page = 1; // default to first page
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10; // default page size
        }
        return sportDao.getSports(pageSize, page);
    }

    @Override
    public Sport getSport(Long id){
        return sportDao.getSport(id);
    }

    @Override
    public Sport save(Sport sport) {
        return sportDao.save(sport);
    }
}

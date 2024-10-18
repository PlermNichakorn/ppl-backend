package se331.project2.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.project2.rest.dao.SportDao;
import se331.project2.rest.entity.Sport;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportServicelmpl implements Sportservice{
    final SportDao sportDao;

    @Override
    public Integer getSportSize(){
        return sportDao.getSportSize();
    }

    @Override
    public List<Sport> getSports(Integer pageSize, Integer page){
        return sportDao.getSports(pageSize, page);
    }

    @Override
    public Sport getSport(Long id){
        return sportDao.getSport(id);
    }
}

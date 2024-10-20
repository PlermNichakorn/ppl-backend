package se331.project2.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.project2.rest.dao.SportDao;
import se331.project2.rest.entity.MedalCountsDTO;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.repository.SportRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportServicelmpl implements SportService {
    final SportDao sportDao;
    final SportRepository sportRepository;

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


    public MedalCountsDTO getMedalCountsByCountryId(Long countryId) {
        Object[] results = sportRepository.findMedalCountsByCountryId(countryId);

        // Ensure results is not null and has the expected number of elements
        Integer goldMedals = (results != null && results.length > 0 && results[0] instanceof Number)
                ? ((Number) results[0]).intValue() : 0;
        Integer silverMedals = (results != null && results.length > 1 && results[1] instanceof Number)
                ? ((Number) results[1]).intValue() : 0;
        Integer bronzeMedals = (results != null && results.length > 2 && results[2] instanceof Number)
                ? ((Number) results[2]).intValue() : 0;

        return new MedalCountsDTO(goldMedals, silverMedals, bronzeMedals);
    }

}

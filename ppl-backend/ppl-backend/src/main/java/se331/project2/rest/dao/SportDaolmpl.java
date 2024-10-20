package se331.project2.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.repository.SportRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Profile("manual")
public class SportDaolmpl implements SportDao{
    List<Sport> sportList;
    final SportRepository sportRepository;

    public SportDaolmpl(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }


//    @PostConstruct
//    public void init() {
//        sportList = new ArrayList<>();
//        sportList.add(Sport.builder()
//                .id(001L)
//                .sportName("Hello")
////                .gold_medals(25L)
////                .silver_medals(10L)
////                .bronze_medals(21L)
//                .build());
//        sportList.add(Sport.builder()
//                .id(002L)
//                .sportName("OK")
////                .gold_medals(10L)
////                .silver_medals(12L)
////                .bronze_medals(13L)
//                .build());
//        sportList.add(Sport.builder()
//                .id(003L)
//                .sportName("What")
////                .gold_medals(5L)
////                .silver_medals(22L)
////                .bronze_medals(8L)
//                .build());
//    }

    @Override
    public Integer getSportSize(){
        return sportList.size();
    }
    @Override
    public Page<Sport> getSports(Integer pageSize, Integer page) {
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Sport>(sportList.subList(firstIndex, firstIndex + pageSize), PageRequest.of(page, pageSize), sportList.size());
    }
    @Override
    public Sport getSport(Long id){
        return sportList.stream().filter(country ->
                country.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Sport save(Sport sport) {
        sport.setId(sportList.get(sportList.size() - 1).getId()+1);
        sportList.add(sport);
        return sportRepository.save(sport);
    }
}

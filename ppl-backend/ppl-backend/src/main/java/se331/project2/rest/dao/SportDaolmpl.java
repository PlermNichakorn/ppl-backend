package se331.project2.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.project2.rest.entity.Sport;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SportDaolmpl implements SportDao{
    List<Sport> sportList;

    @PostConstruct
    public void init() {
        sportList = new ArrayList<>();
        sportList.add(Sport.builder()
                .id(001L)
                .sportName("Basketball")
                .gold_medals(25L)
                .silver_medals(10L)
                .bronze_medals(21L)
                .build());
        sportList.add(Sport.builder()
                .id(002L)
                .sportName("Swimming")
                .gold_medals(10L)
                .silver_medals(12L)
                .bronze_medals(13L)
                .build());
        sportList.add(Sport.builder()
                .id(003L)
                .sportName("Volleyball")
                .gold_medals(5L)
                .silver_medals(22L)
                .bronze_medals(8L)
                .build());
    }

    @Override
    public Integer getSportSize(){
        return sportList.size();
    }
    @Override
    public List<Sport> getSports(Integer pageSize, Integer page) {
        int firstIndex = (page - 1) * pageSize;
        return sportList.subList(firstIndex, firstIndex + pageSize);
    }
    @Override
    public Sport getSport(Long id){
        return sportList.stream().filter(country ->
                country.getId().equals(id)).findFirst().orElse(null);
    }
}

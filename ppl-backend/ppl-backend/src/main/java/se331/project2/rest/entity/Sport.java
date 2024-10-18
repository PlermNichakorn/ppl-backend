package se331.project2.rest.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sport {
    Long id;
    String sportName;
    Long gold_medals;
    Long silver_medals;
    Long bronze_medals;
}

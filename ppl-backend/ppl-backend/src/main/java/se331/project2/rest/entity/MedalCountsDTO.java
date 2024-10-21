package se331.project2.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedalCountsDTO{
    Integer gold_medals;
    Integer silver_medals;
    Integer bronze_medals;
}

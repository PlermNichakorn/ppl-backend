package se331.project2.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedalCountsDTO {
    private Integer gold_medals;
    private Integer silver_medals;
    private Integer bronze_medals;
}

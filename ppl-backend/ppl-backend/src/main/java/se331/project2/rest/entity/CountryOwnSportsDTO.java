package se331.project2.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryOwnSportsDTO {
    Long id;
    String sportName;
    Integer gold_medals;
    Integer silver_medals;
    Integer bronze_medals;
}

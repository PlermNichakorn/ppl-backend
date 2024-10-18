package se331.project2.rest.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Country {
    Long id;
    String countryName;
    String description;
    String image;
    Long gold;
    Long silver;
    Long bronze;
    Long rank;
    String sport;
}

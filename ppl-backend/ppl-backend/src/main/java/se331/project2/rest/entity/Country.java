package se331.project2.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @EqualsAndHashCode.Exclude
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

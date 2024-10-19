package se331.project2.rest.entity;

import jakarta.persistence.*;
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
    Long rankValue;
    String sport;
}

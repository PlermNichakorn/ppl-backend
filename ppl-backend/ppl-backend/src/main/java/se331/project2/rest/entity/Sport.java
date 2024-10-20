package se331.project2.rest.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;
import java.util.ArrayList;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String sportName;
    Integer gold_medals;
    Integer silver_medals;
    Integer bronze_medals;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}

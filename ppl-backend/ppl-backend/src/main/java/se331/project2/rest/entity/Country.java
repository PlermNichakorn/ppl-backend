package se331.project2.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.project2.rest.security.user.User;

import java.util.ArrayList;
import java.util.List;

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
    Long gold_total;
    Long silver_total;
    Long bronze_total;

    @OneToMany(mappedBy = "country")
    @Builder.Default
    List<Sport> ownSports = new ArrayList<>();

    @OneToOne
    User user;
}

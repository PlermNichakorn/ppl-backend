package se331.project2.rest.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "country")
    @Builder.Default
    List<Sport> ownSports = new ArrayList<>();
}

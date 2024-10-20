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
    @Nullable
    Integer gold;
    @Nullable
    Integer silver;
    @Nullable
    Integer bronze;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}

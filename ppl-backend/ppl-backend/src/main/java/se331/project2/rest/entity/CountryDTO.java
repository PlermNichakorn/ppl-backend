package se331.project2.rest.entity;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    Long id;
    String countryName;
    String description;
    String image;
    List<CountryOwnSportsDTO> ownSports = new ArrayList<>();

}

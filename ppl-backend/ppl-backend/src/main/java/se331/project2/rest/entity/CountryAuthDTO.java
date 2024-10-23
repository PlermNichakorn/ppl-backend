package se331.project2.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.project2.rest.security.user.Role;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryAuthDTO {
    Long id;
    String countryName;
    String description;
    String image;
    List<Role> roles = new ArrayList<>();
}

package se331.project2.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.project2.rest.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE =  Mappers.getMapper(LabMapper.class);

    SportDTO getSportDTO (Sport sport);
    List<SportDTO> getSportDto (List<Sport> sports);

    CountryDTO getCountryDTO (Country country);
    List<CountryDTO> getCountryDTO (List<Country> countries);

}
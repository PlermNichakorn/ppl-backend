package se331.project2.rest.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.project2.rest.entity.Country;
import se331.project2.rest.entity.CountryDTO;
import se331.project2.rest.entity.CountryOwnSportsDTO;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.entity.SportCountryDTO;
import se331.project2.rest.entity.SportDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T17:20:48+0700",
    comments = "version: 1.6.0, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public SportDTO getSportDTO(Sport sport) {
        if ( sport == null ) {
            return null;
        }

        SportDTO.SportDTOBuilder sportDTO = SportDTO.builder();

        sportDTO.id( sport.getId() );
        sportDTO.sportName( sport.getSportName() );
        sportDTO.country( countryToSportCountryDTO( sport.getCountry() ) );

        return sportDTO.build();
    }

    @Override
    public List<SportDTO> getSportDto(List<Sport> sports) {
        if ( sports == null ) {
            return null;
        }

        List<SportDTO> list = new ArrayList<SportDTO>( sports.size() );
        for ( Sport sport : sports ) {
            list.add( getSportDTO( sport ) );
        }

        return list;
    }

    @Override
    public CountryDTO getCountryDTO(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO.CountryDTOBuilder countryDTO = CountryDTO.builder();

        countryDTO.id( country.getId() );
        countryDTO.countryName( country.getCountryName() );
        countryDTO.description( country.getDescription() );
        countryDTO.image( country.getImage() );
        countryDTO.ownSports( sportListToCountryOwnSportsDTOList( country.getOwnSports() ) );

        return countryDTO.build();
    }

    @Override
    public List<CountryDTO> getCountryDTO(List<Country> countries) {
        if ( countries == null ) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>( countries.size() );
        for ( Country country : countries ) {
            list.add( getCountryDTO( country ) );
        }

        return list;
    }

    protected SportCountryDTO countryToSportCountryDTO(Country country) {
        if ( country == null ) {
            return null;
        }

        SportCountryDTO.SportCountryDTOBuilder sportCountryDTO = SportCountryDTO.builder();

        sportCountryDTO.id( country.getId() );
        sportCountryDTO.countryName( country.getCountryName() );

        return sportCountryDTO.build();
    }

    protected CountryOwnSportsDTO sportToCountryOwnSportsDTO(Sport sport) {
        if ( sport == null ) {
            return null;
        }

        CountryOwnSportsDTO.CountryOwnSportsDTOBuilder countryOwnSportsDTO = CountryOwnSportsDTO.builder();

        countryOwnSportsDTO.id( sport.getId() );
        countryOwnSportsDTO.sportName( sport.getSportName() );
        countryOwnSportsDTO.gold_medals( sport.getGold_medals() );
        countryOwnSportsDTO.silver_medals( sport.getSilver_medals() );
        countryOwnSportsDTO.bronze_medals( sport.getBronze_medals() );

        return countryOwnSportsDTO.build();
    }

    protected List<CountryOwnSportsDTO> sportListToCountryOwnSportsDTOList(List<Sport> list) {
        if ( list == null ) {
            return null;
        }

        List<CountryOwnSportsDTO> list1 = new ArrayList<CountryOwnSportsDTO>( list.size() );
        for ( Sport sport : list ) {
            list1.add( sportToCountryOwnSportsDTO( sport ) );
        }

        return list1;
    }
}

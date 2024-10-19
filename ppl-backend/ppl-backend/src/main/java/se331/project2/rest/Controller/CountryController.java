package se331.project2.rest.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.project2.rest.entity.Country;
import se331.project2.rest.service.CountryService;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class CountryController {
    final CountryService countryservice;


    @GetMapping("countries")
    public ResponseEntity<?> getCountryLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page) {
        Page<Country> pageOutput = countryservice.getCountries(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent(), responseHeader, HttpStatus.OK);
    }



    @GetMapping("countries/{id}")
        public ResponseEntity<?> getCountry(@PathVariable("id") Long id) {
            Country output = countryservice.getCountry(id);
            if (output != null){
                return ResponseEntity.ok(output);
            }else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
            }
        }
    }



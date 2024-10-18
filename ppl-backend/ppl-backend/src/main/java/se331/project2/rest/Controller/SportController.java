package se331.project2.rest.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.project2.rest.entity.Country;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.service.Countryservice;
import se331.project2.rest.service.Sportservice;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SportController {
    final Sportservice sportservice;


    @GetMapping("sports")
    public ResponseEntity<?> getSportLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page) {
        List<Sport> output =null;
        Integer sportSize = sportservice.getSportSize();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(sportSize));

        try {
            output = sportservice.getSports(perPage, page);
            return ResponseEntity.ok(output);
        } catch (IndexOutOfBoundsException ex) {
            return new ResponseEntity<>(output,responseHeader, HttpStatus.OK); // Return what we have even if it's not a full page
        }
    }


    @GetMapping("sports/{id}")
    public ResponseEntity<?> getSport(@PathVariable("id") Long id) {
        Sport output = sportservice.getSport(id);
        if (output != null){
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
}

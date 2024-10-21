package se331.project2.rest.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project2.rest.entity.MedalCountsDTO;
import se331.project2.rest.entity.Sport;
import se331.project2.rest.service.SportService;
import se331.project2.rest.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class SportController {
    final SportService sportservice;


    @GetMapping("sports")
    public ResponseEntity<?> getSportLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page) {
        Page<Sport> pageOutput = sportservice.getSports(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getSportDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }


    @GetMapping("sports/{id}")
    public ResponseEntity<?> getSport(@PathVariable("id") Long id) {
        Sport output = sportservice.getSport(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getSportDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
    @PostMapping("/sports")
    public ResponseEntity<?> addSport(@RequestBody Sport sport){
        Sport output = sportservice.save(sport);
        return ResponseEntity.ok(LabMapper.INSTANCE.getSportDTO(output));
    }


}

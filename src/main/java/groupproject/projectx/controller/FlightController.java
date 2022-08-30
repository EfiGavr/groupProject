
package groupproject.projectx.controller;

import groupproject.projectx.model.Flight;
import groupproject.projectx.repository.FlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class FlightController {
        @Autowired
    FlightRepository flightRepository;
    
    @GetMapping("/test")
    public List<Flight> getAllFlights(){
    return flightRepository.findAll();
    }
    
    @GetMapping(value = "/test2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test(){
    return ResponseEntity.ok("hello");
    }
}

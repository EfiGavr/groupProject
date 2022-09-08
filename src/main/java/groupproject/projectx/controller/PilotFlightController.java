package groupproject.projectx.controller;

import groupproject.projectx.dtos.FlightDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.dtos.PilotFlightDto;
import groupproject.projectx.services.PilotFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pilotFlight")
public class PilotFlightController {

    @Autowired
    PilotFlightService pilotFlightService;

    @GetMapping("/allPilotFlights")
    public ResponseEntity<GenericResponse> getAllPilotFlights(){
        List<PilotFlightDto> pilotFlightDtos= new ArrayList<>();
        try{
            pilotFlightDtos = pilotFlightService.getAllPilotFlights();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "List Of Pilot-Flights Found", pilotFlightDtos));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error","Error While Searching Pilot-Flight List",null));
        }
    }

    @GetMapping("/pilotFlight/{id}")
    public ResponseEntity<GenericResponse> getFlightById(@PathVariable("id") Integer pilotFlightId) {
        PilotFlightDto pilotFlightDto = new PilotFlightDto();
        try {
            pilotFlightDto = pilotFlightService.getPilotFlightById(pilotFlightId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot - Flight Found", pilotFlightDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Pilot - Flight", null));
        }
    }


}

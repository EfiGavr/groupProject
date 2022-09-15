package groupproject.projectx.controller;


import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.dtos.PilotFlightDto;
import groupproject.projectx.services.PilotFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pilotFlight")
public class PilotFlightController {

    @Autowired
    PilotFlightService pilotFlightService;

    @GetMapping("/allPilotFlights")
    public ResponseEntity<GenericResponse> getAllPilotFlights() {
        List<PilotFlightDto> pilotFlightDtos = new ArrayList<>();
        try {
            pilotFlightDtos = pilotFlightService.getAllPilotFlights();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "List Of Pilot-Flights Found", pilotFlightDtos));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Pilot-Flight List", null));
        }
    }

    @GetMapping("/pilotFlight/{id}")
    public ResponseEntity<GenericResponse> getPilotFlightById(@PathVariable("id") Integer pilotFlightId) {
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

    @GetMapping("/pilotFlightByFlightId/{id}")
    public ResponseEntity<GenericResponse> getPilotFlightByFlightId(@PathVariable("id") Integer flightId) {
        PilotFlightDto pilotFlightDto = new PilotFlightDto();
        try {
            List<PilotFlightDto> pilotFlightDtoList = pilotFlightService.getPilotFlightsFromFlightId(flightId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot - Flight List Found", pilotFlightDtoList));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Pilot - Flight List", null));
        }
    }

    @GetMapping("/pilotFlightByPilotId/{id}")
    public ResponseEntity<GenericResponse> getPilotFlightByPilotId(@PathVariable("id") Integer pilotId) {
        PilotFlightDto pilotFlightDto = new PilotFlightDto();
        try {
            List<PilotFlightDto> pilotFlightDtoList = pilotFlightService.getPilotFlightsFromPilotId(pilotId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot - Flight List Found", pilotFlightDtoList));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Pilot - Flight List", null));
        }
    }

    @PostMapping("/createPilotFlight")
    public ResponseEntity<GenericResponse> setPitotToFlight(
            @RequestBody PilotFlightDto pilotFlightDto) {
        try {
            pilotFlightService.createPilotFlight(pilotFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot - Service Successfully Created", pilotFlightDto));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Pilot-Flight", null));
        }
    }

    @PostMapping("/updatePilotFlight")
    public ResponseEntity<GenericResponse> updatePilotFlight(
            @RequestBody PilotFlightDto pilotFlightDto) {
        try {
            PilotFlightDto pilotFlightDtoUpdated = pilotFlightService.updatePilotFlight(pilotFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot - Flight Successfully Updated", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Deleting Pilot-Flight", null));
        }
    }

    @PostMapping("/deletePilotFlight")
    public ResponseEntity<GenericResponse> deletePilotFlight(
            @RequestBody PilotFlightDto pilotFlightDto) {
        try {
            pilotFlightService.deletePilotFlight(pilotFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot- Flight Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Deleting Pilot-Flight", null));
        }
    }
}

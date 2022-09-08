package groupproject.projectx.controller;

import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.dtos.PilotDto;

import java.util.ArrayList;
import java.util.List;

import groupproject.projectx.dtos.PilotFlightDto;
import groupproject.projectx.services.PilotFlightService;
import groupproject.projectx.services.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/pilots")
public class PilotController {

    @Autowired
    PilotService pilotService;

    @Autowired
    PilotFlightService pilotFlightService;


    //controller for finding all the pilots
    @GetMapping("/allpilots")
    public ResponseEntity<GenericResponse> getAllPilots() {
        List<PilotDto> allPilots = new ArrayList();
        try {
            allPilots = pilotService.getAllPilots();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot List Found", allPilots));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Pilot List", null));
        }
    }

    //    //controler for finding pilots with id
    @GetMapping("/pilot/{id}")
    public ResponseEntity<GenericResponse> getPilotById(@PathVariable("id") Integer pilotId) {
        PilotDto pilotDto;
        try {
            pilotDto = pilotService.getPilotById(pilotId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot Found", pilotDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Pilot", null));
        }
    }

    @PostMapping("/contact")
    public ResponseEntity<GenericResponse> getPilotsByContactNumber(
            @RequestParam("contactNumber") String contactNumber) {
        List<PilotDto> pilots;
        try {
            pilots = pilotService.getPilotsByContactNumber(contactNumber);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot Found", pilots));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Pilot", null));
        }
    }

    @PostMapping("/name")
    public ResponseEntity<GenericResponse> getPilotsByName(
            @RequestParam("name") String name) {
        List<PilotDto> pilots;
        try {
            pilots = pilotService.getPilotsByFname(name);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot Found", pilots));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Pilot", null));
        }
    }

    @PostMapping("/lname")
    public ResponseEntity<GenericResponse> getPilotsByLName(
            @RequestParam("lname") String lname) {
        List<PilotDto> pilotsLname;
        try {
            pilotsLname = pilotService.getPilotsByLname(lname);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot Found", pilotsLname));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Pilot", null));
        }
    }

    @PostMapping("/licence")
    public ResponseEntity<GenericResponse> getPilotsByLicenceNumber(
            @RequestParam("licenceNumber") Integer licenceNumber) {
        PilotDto pilot = new PilotDto();
        try {
            pilot = pilotService.getPilotByLicenceNumber(licenceNumber);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot Found", pilot));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Pilot", null));
        }
    }

    @PostMapping("/createPilot")
    public ResponseEntity<GenericResponse> createPilot(
            @RequestBody PilotDto pilotDto) {
        try {
            pilotService.createPilot(pilotDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot Successfully Created", null));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Pilot", null));
        }
    }

    @PostMapping("/deletePilot")
    public ResponseEntity<GenericResponse> deletePilot(
            @RequestBody PilotDto pilotDto) {
        try {
            pilotService.deletePilot(pilotDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Pilot Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            List<PilotFlightDto> pilotFlightDtos = pilotFlightService.getPilotFlightsFromPilotId(pilotDto.getPilotId());
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Deleting Pilot", pilotFlightDtos));
        }
    }

    @PostMapping("/updatePilot")
    public ResponseEntity<GenericResponse> updatePilot(
            @RequestBody PilotDto pilotDto) {
        try {
            PilotDto pilotDtotest = pilotService.updatePilot(pilotDto);
            return ResponseEntity.ok().body(new GenericResponse("succeed", "Pilot Successfully Updated", pilotDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Pilot update", pilotDto));
        }
    }
}




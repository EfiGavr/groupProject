package groupproject.projectx.controller;

import groupproject.projectx.dtos.AirportDto;
import groupproject.projectx.dtos.AirportFlightDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.repository.AirportFlightRepository;
import groupproject.projectx.services.AirportFlightService;
import groupproject.projectx.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @Autowired
    AirportFlightService airportFlightService;

    @Autowired
    AirportFlightRepository airportFlightRepository;

    @GetMapping("/allAirports")
    public ResponseEntity<GenericResponse> getAllAirports() {
        List<AirportDto> airports;
        try {
            airports = airportService.getAllAirports();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport List Found", airports));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airport List", null));
        }
    }

    @GetMapping("/airport/{id}")
    public ResponseEntity<GenericResponse> getAirportById(
            @PathVariable("id") Integer airportId) {
        new AirportDto();
        AirportDto airport;
        try {
            airport = airportService.getAirportById(airportId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport Found", airport));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airport", null));
        }
    }

    @PostMapping("/country")
    public ResponseEntity<GenericResponse> getAirportsByCountryName(
            @RequestParam("country") String country) {
        List<AirportDto> airportDtos;
        try {
            airportDtos = airportService.getAirportsByCountry(country);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport Found", airportDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airport", null));
        }
    }

    @PostMapping("/city")
    public ResponseEntity<GenericResponse> getAirportsByCityName(
            @RequestParam("city") String city) {
        List<AirportDto> airportDtoList = new ArrayList<>();
        try {
            airportDtoList = airportService.getAirportsByCity(city);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport Found", airportDtoList));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airport", null));
        }
    }

    @PostMapping("/airportname")
    public ResponseEntity<GenericResponse> getAirportsByAirportName(
            @RequestParam("airportname") String airportname) {
        List<AirportDto> airportList;
        try {
            airportList = airportService.getAirportsByAirportname(airportname);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport Found", airportList));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airport", null));
        }

    }

    @PostMapping("/createAirport")
    public ResponseEntity<GenericResponse> createNewAirport(
            @RequestBody AirportDto airportDto) {
        try {
            airportService.createAirport(airportDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport Successfully Created", null));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Airport", null));
        }
    }

    @PostMapping("/deleteAirport")
    public ResponseEntity<GenericResponse> deleteAirport(
            @RequestBody AirportDto airportDto) {
        try {
            if (airportService.existRelatedAirportFlight(airportDto.getAirportId())) {
                List<AirportFlightDto> airportFlightDtos = airportFlightService.getAirportFlightsByFromOrToAirportId(airportDto.getAirportId());
                return ResponseEntity.ok().body(new GenericResponse("Error", "Can Not Delete Airport Which Is Related To A Flight", airportFlightDtos));

            }
            airportService.deleteAirport(airportDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Deleting Airport", null));
        }
    }

    @PostMapping("/updateAirport2")
    public ResponseEntity<GenericResponse> updateAirport2(
            @RequestBody AirportDto airportDto) {
        try {
            airportService.updateAirport(airportDto);
            return ResponseEntity.ok().body(new GenericResponse("succeed", "Airport Successfully Updated", airportDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Airport update", airportDto));
        }
    }
}


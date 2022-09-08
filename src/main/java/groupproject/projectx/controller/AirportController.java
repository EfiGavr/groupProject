package groupproject.projectx.controller;

import groupproject.projectx.dtos.AirportDto;
import groupproject.projectx.dtos.AirportFlightDto;
import groupproject.projectx.dtos.GenericResponse;
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
//            AirportDto airport = new AirportDto(country, city, airportname);
            airportService.createAirport(airportDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport Successfully Created", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Airport", null));
        }
    }

    @PostMapping("/deleteAirport")
    public ResponseEntity<GenericResponse> deleteAirport(
            @RequestBody AirportDto airportDto) {
        try {
            airportService.deleteAirport(airportDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            Integer id = airportDto.getAirportId();
            List<AirportFlightDto> airportFlightDtoList = airportFlightService.getAirportFlightsByFromOrToAirportId(id);
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Deleting Airport", airportFlightDtoList));
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


package groupproject.projectx.controller;

import groupproject.projectx.dtos.AirportFlightDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.services.AirportFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airportFlight")
public class AirportFlightController {

    @Autowired
    private AirportFlightService airportFlightService;


    @GetMapping("/allAirportFlights")
    public ResponseEntity<GenericResponse> getAllAirportFlights() {
//        emailService.sendMailWithAttachment(from, "lenovokonk@gmail.com", "test","Welcome to Airline Company! You will recieve your tickets here with attachment !!!");

        List<AirportFlightDto> allFlights = new ArrayList();
        try {
            allFlights = airportFlightService.getAllAirportFligths();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "List of Airport - Flights Successfully Found", allFlights));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Airport-Flight List", null));
        }
    }

    @GetMapping("/airportFlight/{id}")
    public ResponseEntity<GenericResponse> getAirportFlightById(@PathVariable("id") Integer airportFlightId) {

        AirportFlightDto airportFlightDto = new AirportFlightDto();
        try {
            airportFlightDto = airportFlightService.getAirportFlightDtoById(airportFlightId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flights Successfully Found", airportFlightDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airport-Flight", null));
        }
    }

    @PostMapping("/airportNameDeparture")
    public ResponseEntity<GenericResponse> getAirportFlightsByAirportNameDeparture(
            @RequestParam("airportName") String airportName) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByAirportNameDeparture(airportName);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flights Successfully Found", airportFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airport-Flight", null));
        }
    }

    @PostMapping("/airportNameDestination")
    public ResponseEntity<GenericResponse> getAirportFlightsByAirportNameDestination(
            @RequestParam("airportName") String airportName) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByAirportNameDestination(airportName);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flights Successfully Found", airportFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airport-Flight", null));
        }
    }

    @PostMapping("/countryDeparture")
    public ResponseEntity<GenericResponse> getAirportFlightsByCountryDeparture(
            @RequestParam("country") String country) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByCountryDeparture(country);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flights Successfully Found", airportFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airport-Flight", null));
        }
    }

    @PostMapping("/countryDestination")
    public ResponseEntity<GenericResponse> getAirportFlightsByCountryDestination(
            @RequestParam("country") String country) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByCountryDestination(country);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flights Successfully Found", airportFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airport-Flight", null));
        }
    }

    @PostMapping("/cityDeparture")
    public ResponseEntity<GenericResponse> getAirportFlightsByCityDeparture(
            @RequestParam("city") String country) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByCityDeparture(country);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flights Successfully Found", airportFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airport-Flight", null));
        }
    }

    @PostMapping("/cityDestination")
    public ResponseEntity<GenericResponse> getAirportFlightsByCityDestination(
            @RequestParam("city") String country) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByCityDestination(country);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flights Successfully Found", airportFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airport-Flight", null));
        }
    }

    @PostMapping("fromToDepartDate")
    public ResponseEntity<GenericResponse> getAirportFlightsByDatesAndDestination(
            @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate,
            @RequestParam("countryDeparture") String countryDeparture,
            @RequestParam("countryArrival") String countryArrival,
            @RequestParam(value = "numberOfPassengers", required = false, defaultValue = "1") int numberOfPassengers) {
        List<AirportFlightDto> allFlightsByDepartureDateDestinationAndArrival = new ArrayList();
        try {
            allFlightsByDepartureDateDestinationAndArrival = airportFlightService.getAirportFlightByDepartureArrivalDateAndByDepartureArrivalCountry(departureDate, countryDeparture, countryArrival);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flights Successfully Found", allFlightsByDepartureDateDestinationAndArrival));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airport-Flight", null));
        }
    }

    //create AirportFlight
    @PostMapping("/createAirportFlight")
    public ResponseEntity<GenericResponse> setAirportToFlight(
            @RequestBody AirportFlightDto airportFlightDto) {
        try {
            airportFlightService.createAirportFlight(airportFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport-Flight Successfully Created", null));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Airport-Flight", null));
        }
    }

    @PostMapping("/deleteAirportFlight")
    public ResponseEntity<GenericResponse> deleteAirportFlight(
            @RequestBody AirportFlightDto airportFlightDto) {
        try {
            airportFlightService.deleteAirportFlight(airportFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport- Flight Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Deleting Airport-Flight", null));
        }
    }

    @PostMapping("/updateAirportFlight")
    public ResponseEntity<GenericResponse> updateAirportFlight(
            @RequestBody AirportFlightDto airportFlightDto) {
        try {
            AirportFlightDto airportFlightDtoUpdated = airportFlightService.updateAirportFlight(airportFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airport - Flight Successfully Updated", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Updating Airport-Flight", null));
        }
    }
}

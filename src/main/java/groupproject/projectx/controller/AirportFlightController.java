package groupproject.projectx.controller;

import groupproject.projectx.dtos.AirportFlightDto;
import groupproject.projectx.services.AirportFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airportFlight")
public class AirportFlightController {

    @Autowired
    private AirportFlightService airportFlightService;

    @GetMapping("/allAirportFlights")
    public ResponseEntity<List<AirportFlightDto>> getAllFlights() {
        List<AirportFlightDto> allFlights = new ArrayList();
        try {
            allFlights = airportFlightService.getAllAirportFligths();
            return new ResponseEntity<>(allFlights, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlights, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/airportFlight/{id}")
    public ResponseEntity<AirportFlightDto> getAirportFlightById(@PathVariable("id") Integer airportFlightId) {

        AirportFlightDto airportFlightDto = new AirportFlightDto();
        try {
            airportFlightDto = airportFlightService.getAirportFlightDtoById(airportFlightId);
            return new ResponseEntity<>(airportFlightDto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(airportFlightDto, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/airportNameDeparture")
    public ResponseEntity<List<AirportFlightDto>> getAirportFlightsByAirportNameDeparture(
            @RequestParam("airportName") String airportName) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByAirportNameDeparture(airportName);
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/airportNameDestination")
    public ResponseEntity<List<AirportFlightDto>> getAirportFlightsByAirportNameDestination(
            @RequestParam("airportName") String airportName) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByAirportNameDestination(airportName);
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/countryDeparture")
    public ResponseEntity<List<AirportFlightDto>> getAirportFlightsByCountryDeparture(
            @RequestParam("country") String country) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByCountryDeparture(country);
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/countryDestination")
    public ResponseEntity<List<AirportFlightDto>> getAirportFlightsByCountryDestination(
            @RequestParam("country") String country) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByCountryDestination(country);
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cityDeparture")
    public ResponseEntity<List<AirportFlightDto>> getAirportFlightsByCityDeparture(
            @RequestParam("city") String country) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByCityDeparture(country);
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cityDestination")
    public ResponseEntity<List<AirportFlightDto>> getAirportFlightsByCityDestination(
            @RequestParam("city") String country) {
        List<AirportFlightDto> airportFlightDtos = new ArrayList<>();
        try {
            airportFlightDtos = airportFlightService.getAirportFlightByCityDestination(country);
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(airportFlightDtos, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("fromToDepartDate")
    public ResponseEntity<List<AirportFlightDto>> getAirportFlightsByDatesAndDestination(
            @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate,
            @RequestParam("countryDeparture") String countryDeparture,
            @RequestParam("countryArrival") String countryArrival,
            @RequestParam(value = "numberOfPassengers", required = false, defaultValue = "1") int numberOfPassengers) {
        List<AirportFlightDto> allFlightsByDepartureDateDestinationAndArrival = new ArrayList();
        try {
            allFlightsByDepartureDateDestinationAndArrival = airportFlightService.getAirportFlightByDepartureArrivalDateAndByDepartureArrivalCountry(departureDate, countryDeparture, countryArrival);
            return new ResponseEntity<>(allFlightsByDepartureDateDestinationAndArrival, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByDepartureDateDestinationAndArrival, HttpStatus.BAD_REQUEST);
        }
    }
}

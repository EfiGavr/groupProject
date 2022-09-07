package groupproject.projectx.controller;

import groupproject.projectx.dtos.FlightDto;
import groupproject.projectx.model.Flight;
import groupproject.projectx.services.FlightService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    //controller for finding all the flights
    @GetMapping("/allflights")
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> allFlights = new ArrayList();
        try {
            allFlights = flightService.getAllFlights();
            return new ResponseEntity<>(allFlights, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlights, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable("id") Integer flightId) {
        FlightDto flightDto = new FlightDto();
        try {
            flightDto = flightService.getFlightById(flightId);
            return new ResponseEntity<>(flightDto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(flightDto, HttpStatus.BAD_REQUEST);
        }
    }

    //controller for finding all the flights for a specific departure date
    @PostMapping("/daydeparturerange")
    public ResponseEntity<List<FlightDto>> getFlightsByDepartureByDayRange(
            @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate) {
        List<FlightDto> allFlightsByDeparture = new ArrayList();
        try {
            allFlightsByDeparture = flightService.findByDepartureByDayRange(departureDate);
            return new ResponseEntity<>(allFlightsByDeparture, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByDeparture, HttpStatus.BAD_REQUEST);
        }

    }

    //controller for finding all the flights between two departure dates
    @PostMapping("/twodeparturedaysrange")
    public ResponseEntity<List<FlightDto>> getFlightsByDepartureByTwoDaysRange(
            @RequestParam("departureDateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateFrom,
            @RequestParam("departureDateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTo
    ) {
        List<FlightDto> allFlightsByDeparture = new ArrayList();
        try {
            allFlightsByDeparture = flightService.findByDepartureBetweenTwoDates(departureDateFrom, departureDateTo);
            return new ResponseEntity<>(allFlightsByDeparture, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByDeparture, HttpStatus.BAD_REQUEST);
        }

    }

    //controller for finding all the flights for a specific arrival date
    @PostMapping("/dayarrivalrange")
    public ResponseEntity<List<FlightDto>> getFlightsByArrivalByDayRange(
            @RequestParam("arrivalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDate) {
        List<FlightDto> allFlightsByArrival = new ArrayList();
        try {
            allFlightsByArrival = flightService.findByArrivalByDayRange(arrivalDate);
            return new ResponseEntity<>(allFlightsByArrival, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByArrival, HttpStatus.BAD_REQUEST);
        }

    }

    //controller for finding all the flights between two arrival dates
    @PostMapping("/twoarrivaldaysrange")
    public ResponseEntity<List<FlightDto>> getFlightsByArrivalByTwoDaysRange(
            @RequestParam("arrivalDateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDateFrom,
            @RequestParam("arrivalDateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDateTo
    ) {
        List<FlightDto> allFlightsByArrival = new ArrayList();
        try {
            allFlightsByArrival = flightService.findByArrivalBetweenTwoDates(arrivalDateFrom, arrivalDateTo);
            return new ResponseEntity<>(allFlightsByArrival, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByArrival, HttpStatus.BAD_REQUEST);
        }
    }
}


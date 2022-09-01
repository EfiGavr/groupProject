package groupproject.projectx.controller;

import groupproject.projectx.model.Flight;
import groupproject.projectx.services.FlightService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    //controller for finding all the flights
    @GetMapping("/allflights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> allFlights = new ArrayList();
        try {
            allFlights = flightService.getAllFlights();
            return new ResponseEntity<>(allFlights, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlights, HttpStatus.BAD_REQUEST);
        }
    }

    //controller for finding all the flights for a specific departure date
    @PostMapping("/flight/daydeparturerange")
    public ResponseEntity<List<Flight>> getFlightsByDepartureByDayRange(
            @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate) {
        List<Flight> allFlightsByDeparture = new ArrayList();
        try {
            allFlightsByDeparture = flightService.findByDepartureByDayRange(departureDate);
            return new ResponseEntity<>(allFlightsByDeparture, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByDeparture, HttpStatus.BAD_REQUEST);
        }

    }

    //controller for finding all the flights between two departure dates
    @PostMapping("/flight/twodeparturedaysrange")
    public ResponseEntity<List<Flight>> getFlightsByDepartureByTwoDaysRange(
            @RequestParam("departureDateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateFrom,
            @RequestParam("departureDateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTo
    ) {
        List<Flight> allFlightsByDeparture = new ArrayList();
        try {
            allFlightsByDeparture = flightService.findByDepartureBetweenTwoDates(departureDateFrom, departureDateTo);
            return new ResponseEntity<>(allFlightsByDeparture, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByDeparture, HttpStatus.BAD_REQUEST);
        }

    }

    //controller for finding all the flights for a specific arrival date
    @PostMapping("/flight/dayarrivalrange")
    public ResponseEntity<List<Flight>> getFlightsByArrivalByDayRange(
            @RequestParam("arrivalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDate) {
        List<Flight> allFlightsByArrival = new ArrayList();
        try {
            allFlightsByArrival = flightService.findByArrivalByDayRange(arrivalDate);
            return new ResponseEntity<>(allFlightsByArrival, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByArrival, HttpStatus.BAD_REQUEST);
        }

    }

    //controller for finding all the flights between two arrival dates
    @PostMapping("/flight/twoarrivaldaysrange")
    public ResponseEntity<List<Flight>> getFlightsByArrivalByTwoDaysRange(
            @RequestParam("arrivalDateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDateFrom,
            @RequestParam("arrivalDateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDateTo
    ) {
        List<Flight> allFlightsByArrival = new ArrayList();
        try {
            allFlightsByArrival = flightService.findByArrivalBetweenTwoDates(arrivalDateFrom, arrivalDateTo);
            return new ResponseEntity<>(allFlightsByArrival, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allFlightsByArrival, HttpStatus.BAD_REQUEST);
        }

    }
}

package groupproject.projectx.controller;

import groupproject.projectx.dtos.AirportDto;
import groupproject.projectx.dtos.AirportFlightDto;
import groupproject.projectx.dtos.FlightDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.model.Flight;
import groupproject.projectx.services.AirportFlightService;
import groupproject.projectx.services.FlightService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    AirportFlightService airportFlightService;

    //controller for finding all the flights
    @GetMapping("/allflights")
    public ResponseEntity<GenericResponse> getAllFlights() {
        List<FlightDto> allFlights;
        try {
            allFlights = flightService.getAllFlights();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flight List Found", allFlights));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Flight List", null));
        }
    }


    @GetMapping("/flight/{id}")
    public ResponseEntity<GenericResponse> getFlightById(@PathVariable("id") Integer flightId) {
        FlightDto flightDto = new FlightDto();
        try {
            flightDto = flightService.getFlightById(flightId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flight Found", flightDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Flight", null));
        }
    }

    //controller for finding all the flights for a specific departure date
    @PostMapping("/daydeparturerange")
    public ResponseEntity<GenericResponse> getFlightsByDepartureByDayRange(
            @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate) {
        List<FlightDto> allFlightsByDeparture;
        try {
            allFlightsByDeparture = flightService.findByDepartureByDayRange(departureDate);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flights Found", allFlightsByDeparture));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Flights", null));
        }
    }

    //controller for finding all the flights between two departure dates
    @PostMapping("/twodeparturedaysrange")
    public ResponseEntity<GenericResponse> getFlightsByDepartureByTwoDaysRange(
            @RequestParam("departureDateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateFrom,
            @RequestParam("departureDateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTo
    ) {
        List<FlightDto> allFlightsByDeparture;
        try {
            allFlightsByDeparture = flightService.findByDepartureBetweenTwoDates(departureDateFrom, departureDateTo);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flights Found", allFlightsByDeparture));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Flights", null));
        }
    }

    //controller for finding all the flights for a specific arrival date
    @PostMapping("/dayarrivalrange")
    public ResponseEntity<GenericResponse> getFlightsByArrivalByDayRange(
            @RequestParam("arrivalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDate) {
        List<FlightDto> allFlightsByArrival;
        try {
            allFlightsByArrival = flightService.findByArrivalByDayRange(arrivalDate);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flights Found", allFlightsByArrival));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Flights", null));
        }
    }


    //controller for finding all the flights between two arrival dates
    @PostMapping("/twoarrivaldaysrange")
    public ResponseEntity<GenericResponse> getFlightsByArrivalByTwoDaysRange(
            @RequestParam("arrivalDateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDateFrom,
            @RequestParam("arrivalDateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDateTo
    ) {
        List<FlightDto> allFlightsByArrival;
        try {
            allFlightsByArrival = flightService.findByArrivalBetweenTwoDates(arrivalDateFrom, arrivalDateTo);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flights Found", allFlightsByArrival));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Flights", null));
        }
    }

    @PostMapping("/createFlight")
    public ResponseEntity<GenericResponse> createNewFlight(
            @RequestBody FlightDto flightDto) {
        try {
            flightService.createFlight(flightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flight Successfully Created", null));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Flight", null));
        }
    }

    @PostMapping("/deleteFlight")
    public ResponseEntity<GenericResponse> deleteFlight(
            @RequestBody FlightDto flightDto) {
        try {
            flightService.deleteFlight(flightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flight Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            airportFlightService.deleteAirportFlightWhichConnectWithFlightToDelete(flightDto.getFlightId());
            flightService.deleteFlight(flightDto);
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Flight Successfully Deleted, after deleting all the Airport - Flight Connections", null));
        }
    }

    @PostMapping("/updateFlight")
    public ResponseEntity<GenericResponse> updateFlight(
            @RequestBody FlightDto flightDto) {
        try {
            flightService.updateFlight(flightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Flight Successfullu Updated", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Updating Flight", null));
        }
    }


}


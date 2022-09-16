/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupproject.projectx.controller;

import groupproject.projectx.dtos.AirplaneFlightDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.services.AirplaneFlightService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ironm
 */
@RestController
@RequestMapping("/airplaneflight")
public class AirplaneFlightController {
    
    @Autowired
    private AirplaneFlightService airplaneFlightService;
    
    @GetMapping("allairplaneflights")
    public ResponseEntity<GenericResponse> getAllAirplaneFlights(){
    List<AirplaneFlightDto> allAirplanes = new ArrayList();
        try {
            allAirplanes = airplaneFlightService.getAllAirplaneFlights();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "List of Airplane - Flights Successfully Found", allAirplanes));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Airplane-Flight List", null));
        }
    }
    
    @PostMapping("airplanesbymanufacture")
    public ResponseEntity<GenericResponse> getAirplaneFlightsByManufacture(@RequestParam("manufacture") String manufacture){
    List<AirplaneFlightDto> airplaneFlightDtos = new ArrayList<>();
        try {
            airplaneFlightDtos = airplaneFlightService.getAllAirplaneFlightsByManufacture(manufacture);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane - Flights Successfully Found", airplaneFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airplane-Flight", null));
        }
    }
    
    @PostMapping("airplanesbymodelnumber")
    public ResponseEntity<GenericResponse> getAllAirplaneFlightsByModelNumber(@RequestParam("modelNumber") String modelNumber) {
    List<AirplaneFlightDto> airplaneFlightDtos = new ArrayList<>();
        try {
            airplaneFlightDtos = airplaneFlightService.getAllAirplaneFlightsByModelNumber(modelNumber);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane - Flights Successfully Found", airplaneFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airplane-Flight", null));
        }
    }
    
    @PostMapping("airplanesbycapacity")
    public ResponseEntity<GenericResponse> getAllairplanesByCapacity(@RequestParam("capacity") Integer capacity){
    List<AirplaneFlightDto> airplaneFlightDtos = new ArrayList<>();
        try {
            airplaneFlightDtos = airplaneFlightService.getAllAirplaneFlightsByCapacity(capacity);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane - Flights Successfully Found", airplaneFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airplane-Flight", null));
        }
    }
    
    @PostMapping("/flightsbydeparturedate")
    public ResponseEntity<GenericResponse> getAirplaneFlightsByDeparture(@RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate){
    List<AirplaneFlightDto> airplaneFlightDtos = new ArrayList<>();
        try {
            airplaneFlightDtos = airplaneFlightService.getAllAirplaneFlightsByDeparture(departureDate);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane - Flights Successfully Found", airplaneFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airplane-Flight", null));
        }
    }
    
    @PostMapping("/flightsbyarrivaldate")
    public ResponseEntity<GenericResponse> getAirplaneFlightsByArrival(@RequestParam("arrivalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDate){
    List<AirplaneFlightDto> airplaneFlightDtos = new ArrayList<>();
        try {
            airplaneFlightDtos = airplaneFlightService.getAllAirplaneFlightsByArrival(arrivalDate);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane - Flights Successfully Found", airplaneFlightDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Airplane-Flight", null));
        }
    }
    
    @PostMapping("/createairplaneflight")
    public ResponseEntity<GenericResponse> createAirplaneFlight(@RequestBody AirplaneFlightDto airplaneFlightDto) {
    try {
            airplaneFlightService.createAirplaneFlight(airplaneFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane-Flight Successfully Created", null));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Airplane-Flight", null));
        }
    }
    
    @PostMapping("/deleteairplaneflight")
    public ResponseEntity<GenericResponse> deleteAirplaneFlight(@RequestBody AirplaneFlightDto airplaneFlightDto){
     try {
            airplaneFlightService.deleteAirplaneFlight(airplaneFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane - Flight Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Deleting Airplane-Flight", null));
        }
    }
    
    @PostMapping("/updateairplaneflight")
    public ResponseEntity<GenericResponse> updateAirplaneFlight(@RequestBody AirplaneFlightDto airplaneFlightDto){
    try {
            AirplaneFlightDto airplaneFlightDtoUpdated = airplaneFlightService.updateAirplaneFlight(airplaneFlightDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane - Flight Successfully Updated", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Updating Airplane-Flight", null));
        }
    }
    
}

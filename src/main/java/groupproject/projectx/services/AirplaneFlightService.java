/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package groupproject.projectx.services;

import groupproject.projectx.dtos.AirplaneFlightDto;
import groupproject.projectx.model.AirplaneFlight;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ironm
 */
public interface AirplaneFlightService {
    List<AirplaneFlightDto> getAllAirplaneFlights();
    List<AirplaneFlightDto> getAllAirplanesByManufacture(String manufacture);
    List<AirplaneFlightDto> getAllAirplaneFlightsByModelNumber(String modelNumber);
    List<AirplaneFlightDto> getAllAirplaneFlightsByCapacity(int capacity);
    List<AirplaneFlightDto> getAllAirplaneFlightsByDeparture(LocalDateTime departureDate);
    List<AirplaneFlightDto> getAllAirplaneFlightsByArrival(LocalDateTime arrivalDate);
    void deleteAirplaneFlightWhichConnectWithAirplaneToDelete(Integer airplaneId);
    void createAirplaneFlight(AirplaneFlightDto airplaneFlightDto);
    void deleteAirplaneFlight(AirplaneFlightDto airplaneFlightDto);
    AirplaneFlightDto updateAirplaneFlight(AirplaneFlightDto airplaneFlightDto);
    AirplaneFlightDto convertToAirplaneFlightDto(AirplaneFlight airplaneFlight);
    AirplaneFlight convertToAirplaneFlight(AirplaneFlightDto airplaneFlightDto);
    List<AirplaneFlightDto> convertToDtoList(List<AirplaneFlight> airplaneFlights);
    
    
    
    
    
}

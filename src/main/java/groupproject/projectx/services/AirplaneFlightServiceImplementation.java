/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupproject.projectx.services;

import groupproject.projectx.dtos.AirplaneFlightDto;
import groupproject.projectx.model.AirplaneFlight;
import groupproject.projectx.repository.AirplaneFlightRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ironm
 */
@Service

public class AirplaneFlightServiceImplementation implements AirplaneFlightService {

    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    AirplaneFlightRepository airplaneFlightRepository;
    
    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlights() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplanesByManufacture(String manufacture) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByModelNumber(String modelNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByCapacity(int capacity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByDeparture(LocalDateTime departureDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByArrival(LocalDateTime arrivalDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAirplaneFlightWhichConnectWithAirplaneToDelete(Integer airplaneId) {
        List<AirplaneFlight> airplaneFlights = airplaneFlightRepository.findAllByAirplane_AirplaneId(airplaneId);
        for (int i = 0; i < airplaneFlights.size(); i++) {
            airplaneFlightRepository.deleteById((airplaneFlights.get(i)).getAirplaneFlightId());
        }
    }

    @Override
    public void createAirplaneFlight(AirplaneFlightDto airplaneFlightDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAirplaneFlight(AirplaneFlightDto airplaneFlightDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AirplaneFlightDto updateAirplaneFlight(AirplaneFlightDto airplaneFlightDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AirplaneFlightDto convertToAirplaneFlightDto(AirplaneFlight airplaneFlight) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AirplaneFlight convertToAirplaneFlight(AirplaneFlightDto airplaneFlightDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AirplaneFlightDto> convertToDtoList(List<AirplaneFlight> airplaneFlights) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

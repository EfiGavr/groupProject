/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupproject.projectx.services;

import groupproject.projectx.dtos.AirplaneFlightDto;
import groupproject.projectx.model.AirplaneFlight;
import groupproject.projectx.repository.AirplaneFlightRepository;
import groupproject.projectx.repository.AirplaneRepository;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    
    @Autowired
    AirplaneRepository airplaneRepository;
    
    
    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlights() {
        List<AirplaneFlight> airplaneFlights = airplaneFlightRepository.findAll();
        return convertToDtoList(airplaneFlights);
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByManufacture(String manufacture) {
        List<AirplaneFlight> airplaneFlights = airplaneFlightRepository.findByAirplane_Manufacture(manufacture);
        if (airplaneFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airplane Found made by this manufacture");
        } else {
            return convertToDtoList(airplaneFlights);
        }
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByModelNumber(String modelNumber) {
        List<AirplaneFlight> airplaneFlights = airplaneFlightRepository.findByAirplane_ModelNumber(modelNumber);
        if (airplaneFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airplane Found made with this Modelnumber");
        } else {
            return convertToDtoList(airplaneFlights);
        }
    }
    
    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByCapacity(Integer capacity) {
         List<AirplaneFlight> airplaneFlights = airplaneFlightRepository.findByAirplane_Capacity(capacity);
        if (airplaneFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airplane Found with this Capacity");
        } else {
            return convertToDtoList(airplaneFlights);
        }
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByDeparture(LocalDateTime departureDate) {
         List<AirplaneFlight> airplaneFlights = airplaneFlightRepository.findByFlight_DepartureBetween(departureDate, departureDate.plusHours(24).minusSeconds(1));
        if (airplaneFlights.isEmpty()) {
            throw new EntityNotFoundException("No Flights Found with this Departure Date");
        } else {
            return convertToDtoList(airplaneFlights);
        }
    }

    @Override
    public List<AirplaneFlightDto> getAllAirplaneFlightsByArrival(LocalDateTime arrivalDate) {
         List<AirplaneFlight> airplaneFlights = airplaneFlightRepository.findByFlight_ArrivalBetween(arrivalDate, arrivalDate.plusHours(24).minusSeconds(1));
        if (airplaneFlights.isEmpty()) {
            throw new EntityNotFoundException("No Flights Found with this Arrival Date");
        } else {
            return convertToDtoList(airplaneFlights);
        }
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
        AirplaneFlight newAirplaneFlight = convertToAirplaneFlight(airplaneFlightDto);
        airplaneFlightRepository.save(newAirplaneFlight);
    }

    @Override
    public void deleteAirplaneFlight(AirplaneFlightDto airplaneFlightDto) {
        airplaneFlightRepository.deleteById(airplaneFlightDto.getAirplaneFlightId());
    }

    @Override
    public AirplaneFlightDto updateAirplaneFlight(AirplaneFlightDto airplaneFlightDto) {
        boolean isAirportFlightExist = airplaneFlightRepository.existsById(airplaneFlightDto.getAirplaneFlightId());
        if (isAirportFlightExist) {
            AirplaneFlight airplaneFlight = convertToAirplaneFlight(airplaneFlightDto);
            airplaneFlightRepository.save(airplaneFlight);
            return convertToAirplaneFlightDto(airplaneFlight);
        } else {
            throw new EntityNotFoundException("Airplane - Flight Not Found");
        }
    }

    @Override
    public AirplaneFlightDto convertToAirplaneFlightDto(AirplaneFlight airplaneFlight) {
        return modelMapper.map(airplaneFlight, AirplaneFlightDto.class);
    }

    @Override
    public AirplaneFlight convertToAirplaneFlight(AirplaneFlightDto airplaneFlightDto) {
        return modelMapper.map(airplaneFlightDto, AirplaneFlight.class);
    }

    @Override
    public List<AirplaneFlightDto> convertToDtoList(List<AirplaneFlight> airplaneFlights) {
        TypeToken<List<AirplaneFlightDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(airplaneFlights, typeToken.getType());
    }

    
    
}

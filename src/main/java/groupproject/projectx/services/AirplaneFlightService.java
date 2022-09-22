
package groupproject.projectx.services;

import groupproject.projectx.dtos.AirplaneFlightDto;
import groupproject.projectx.model.AirplaneFlight;

import java.time.LocalDateTime;
import java.util.List;

public interface AirplaneFlightService {
    List<AirplaneFlightDto> getAllAirplaneFlights();

    List<AirplaneFlightDto> getAllAirplaneFlightsByManufacture(String manufacture);

    List<AirplaneFlightDto> getAllAirplaneFlightsByModelNumber(String modelNumber);

    List<AirplaneFlightDto> getAllAirplaneFlightsByCapacity(Integer capacity);

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

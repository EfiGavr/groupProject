package groupproject.projectx.services;

import groupproject.projectx.dtos.FlightDto;
import groupproject.projectx.model.Flight;
import groupproject.projectx.repository.FlightRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FlightRepository flightRepository;

    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return convertToDtoList(flights);
    }

    public FlightDto getFlightById(Integer flightId) {
        //get optional flight
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        //if it exists
        if (flightOptional.isPresent()) {
            // get this flight
            Flight flight = flightOptional.get();
            //convert it to flight dto  and return it
            return convertToFlightDto(flight);
        }
        //TODO throw Exception
        return new FlightDto();
    }

//    public void insertFlight(Flight flight) {
//        flightRepository.save(flight);
//    }

    public List<FlightDto> findByDepartureByDayRange(LocalDateTime departure) {
        List<Flight> flights = flightRepository.findAllByDepartureBetween(departure, departure.plusHours(24).minusSeconds(1));
        return convertToDtoList(flights);
    }

    public List<FlightDto> findByDepartureBetweenTwoDates(LocalDateTime departureStartDate, LocalDateTime departureEndDate) {
        List<Flight> flights = flightRepository.findAllByDepartureBetween(departureStartDate, departureEndDate.plusHours(24).minusSeconds(1));
        return convertToDtoList(flights);
    }

    public List<FlightDto> findByArrivalByDayRange(LocalDateTime arrival) {
        List<Flight> flights = flightRepository.findAllByArrivalBetween(arrival, arrival.plusHours(24).minusSeconds(1));
        return convertToDtoList(flights);
    }

    public List<FlightDto> findByArrivalBetweenTwoDates(LocalDateTime arrivalStartDate, LocalDateTime arrivalEndDate) {
        List<Flight> flights = flightRepository.findAllByArrivalBetween(arrivalStartDate, arrivalEndDate.plusHours(24).minusSeconds(1));
        return convertToDtoList(flights);
    }


    public FlightDto convertToFlightDto(Flight flight) {
        return modelMapper.map(flight, FlightDto.class);
    }

    public List<FlightDto> convertToDtoList(List<Flight> flights) {
        TypeToken<List<FlightDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(flights, typeToken.getType());
    }


}


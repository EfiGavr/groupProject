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

import javax.persistence.EntityNotFoundException;

@Service
public class FlightService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FlightRepository flightRepository;

    public List<FlightDto> getAllFlights() {
        return convertToDtoList(flightRepository.findAll());
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
        } else {
            throw new EntityNotFoundException("Flight Not Found");
        }
    }

    public List<FlightDto> findByDepartureByDayRange(LocalDateTime departure) {
        List<FlightDto> flights = convertToDtoList(flightRepository.findAllByDepartureBetween(departure, departure.plusHours(24).minusSeconds(1)));
        if (flights.isEmpty()) {
            throw new EntityNotFoundException("No Flights Found For This Departure Date");
        } else {
            return flights;
        }
    }

    public List<FlightDto> findByDepartureBetweenTwoDates(LocalDateTime departureStartDate, LocalDateTime departureEndDate) {
        List<FlightDto> flights = convertToDtoList(flightRepository.findAllByDepartureBetween(departureStartDate, departureEndDate.plusHours(24).minusSeconds(1)));
        if (flights.isEmpty()) {
            throw new EntityNotFoundException("No Flights Found For These Departure Dates");
        } else {
            return flights;
        }
    }

    public List<FlightDto> findByArrivalByDayRange(LocalDateTime arrival) {
        List<FlightDto> flights = convertToDtoList(flightRepository.findAllByArrivalBetween(arrival, arrival.plusHours(24).minusSeconds(1)));
        if (flights.isEmpty()) {
            throw new EntityNotFoundException("No Flights Found For This Arrival Date");
        } else {
            return flights;
        }
    }

    public List<FlightDto> findByArrivalBetweenTwoDates(LocalDateTime arrivalStartDate, LocalDateTime arrivalEndDate) {
        List<FlightDto> flights = convertToDtoList(flightRepository.findAllByArrivalBetween(arrivalStartDate, arrivalEndDate.plusHours(24).minusSeconds(1)));
        if (flights.isEmpty()) {
            throw new EntityNotFoundException("No Flights Found For These Arrival Dates");
        } else {
            return flights;
        }
    }

    public void createFlight(FlightDto flightDto) {
        Flight newFlight = convertToFlight(flightDto);
        flightRepository.save(newFlight);
    }

    public void deleteFlight(FlightDto flightDto) {
        flightRepository.deleteById(flightDto.getFlightId());
    }

    public FlightDto updateFlight(FlightDto updatedFlightDto) {
        boolean isFlightExist = flightRepository.existsById(updatedFlightDto.getFlightId());
        if (isFlightExist) {
            Flight flight = convertToFlight(updatedFlightDto);
            flightRepository.save(flight);
            return convertToFlightDto(flight);
        } else {
            throw new EntityNotFoundException("Flight Not Found");
        }
    }


    public FlightDto convertToFlightDto(Flight flight) {
        return modelMapper.map(flight, FlightDto.class);
    }

    public Flight convertToFlight(FlightDto flightDto) {
        return modelMapper.map(flightDto, Flight.class);
    }

    public List<FlightDto> convertToDtoList(List<Flight> flights) {
        TypeToken<List<FlightDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(flights, typeToken.getType());
    }


}


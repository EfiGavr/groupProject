package groupproject.projectx.services;

import groupproject.projectx.dtos.AirportDto;
import groupproject.projectx.model.Airport;
import groupproject.projectx.repository.AirportFlightRepository;
import groupproject.projectx.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirportFlightRepository airportFlightRepository;

    public AirportDto getAirportById(Integer airportId) {
        Optional<Airport> airportOptional = airportRepository.findById(airportId);
        if (airportOptional.isPresent()) {
            Airport airport = airportOptional.get();
            return convertToAirportDto(airport);
        } else {
            throw new EntityNotFoundException("Airport Not Found");
        }
    }

    public List<AirportDto> getAllAirports() {
        return convertToDtoList(airportRepository.findAll());
    }

    public List<AirportDto> getAirportsByCountry(String country) {
        List<AirportDto> airports = convertToDtoList(airportRepository.findAllByCountry(country));
        if (airports.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This Country");
        } else {
            return airports;
        }
    }

    public List<AirportDto> getAirportsByCity(String city) {
        List<AirportDto> airports = convertToDtoList(airportRepository.findAllByCity(city));
        if (airports.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This City");
        } else {
            return airports;
        }
    }

    public List<AirportDto> getAirportsByAirportname(String airportname) {
        List<AirportDto> airports = convertToDtoList(airportRepository.findAllByAirportname(airportname));
        if (airports.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This Airportname");
        } else {
            return airports;
        }
    }

    public void createAirport(AirportDto airportDto) {
        Airport newAirport = convertToAirport(airportDto);
        airportRepository.save(newAirport);
    }

    public Boolean existRelatedAirportFlight(Integer airportId) {
        boolean exist = false;
        if (airportFlightRepository.existsByFrom1_AirportIdOrTo_AirportId(airportId, airportId)) {
            exist = true;
        }
        return exist;
    }

    public void deleteAirport(AirportDto airportDto) {
        airportRepository.deleteById(airportDto.getAirportId());
    }

    public AirportDto updateAirport(AirportDto updatedAirportDto) {
        boolean isAirportExist = airportRepository.existsById(updatedAirportDto.getAirportId());
        if (isAirportExist) {
            Airport airport = convertToAirport(updatedAirportDto);
            airportRepository.save(airport);
            return convertToAirportDto(airport);
        } else {
            throw new EntityNotFoundException("Airport Not Found");
        }
    }

    public AirportDto convertToAirportDto(Airport airport) {
        return modelMapper.map(airport, AirportDto.class);
    }

    public Airport convertToAirport(AirportDto airportDto) {
        return modelMapper.map(airportDto, Airport.class);
    }

    public List<AirportDto> convertToDtoList(List<Airport> airports) {
        TypeToken<List<AirportDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(airports, typeToken.getType());
    }
}

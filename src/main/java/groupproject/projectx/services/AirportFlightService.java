package groupproject.projectx.services;

import groupproject.projectx.dtos.AirportFlightDto;
import groupproject.projectx.model.Airport;
import groupproject.projectx.model.AirportFlight;
import groupproject.projectx.model.Flight;
import groupproject.projectx.repository.AirportFlightRepository;
import groupproject.projectx.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AirportFlightService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AirportFlightRepository airportFlightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private FlightService flightService;

    public List<AirportFlightDto> getAllAirportFligths() {
        List<AirportFlight> airportFlights = airportFlightRepository.findAll();
        return convertToDtoList(airportFlights);
    }

    public AirportFlightDto getAirportFlightDtoById(Integer airportFlightId) {
        //get optional flight
        Optional<AirportFlight> airportFlightOptional = airportFlightRepository.findById(airportFlightId);
        //if it exists
        if (airportFlightOptional.isPresent()) {
            // get this flight
            AirportFlight airportFlight = airportFlightOptional.get();
            //convert it to flight dto  and return it
            return convertToAirportFlightDto(airportFlight);
        }
        throw new EntityNotFoundException("Airport-Flight Not Found");
    }

    public List<AirportFlightDto> getAirportFlightByAirportNameDeparture(String airportname) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByFrom1_AirportnameIs(airportname);
        if (airportFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This Departure Airport");
        } else {
            return convertToDtoList(airportFlights);
        }
    }

    public List<AirportFlightDto> getAirportFlightByAirportNameDestination(String airportname) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByTo_AirportnameIs(airportname);
        if (airportFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This Destination Airport");
        } else {
            return convertToDtoList(airportFlights);
        }
    }

    public List<AirportFlightDto> getAirportFlightByCountryDeparture(String country) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByFrom1_CountryIs(country);
        if (airportFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This Country Departure");
        } else {
            return convertToDtoList(airportFlights);
        }
    }

    public List<AirportFlightDto> getAirportFlightByCountryDestination(String country) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByTo_CountryIs(country);
        if (airportFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This Country Destination");
        } else {
            return convertToDtoList(airportFlights);
        }
    }

    public List<AirportFlightDto> getAirportFlightByCityDeparture(String city) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByFrom1_CityIs(city);
        if (airportFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This City Departure");
        } else {
            return convertToDtoList(airportFlights);
        }
    }

    public List<AirportFlightDto> getAirportFlightByCityDestination(String city) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByTo_CityIs(city);
        if (airportFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This City Destination");
        } else {
            return convertToDtoList(airportFlights);
        }
    }

    public List<AirportFlightDto> getAirportFlightByDepartureArrivalDateAndByDepartureArrivalCountry(LocalDateTime departureStartDate, String countryDeparture, String countryArrival) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByFlight_DepartureBetweenAndFrom1_CountryIsAndTo_CountryIs(departureStartDate, departureStartDate.plusHours(24).minusSeconds(1), countryDeparture, countryArrival);
        if (airportFlights.isEmpty()) {
            throw new EntityNotFoundException("No Airport Found For This Departure Date and Countries Of Departure And Destination");
        } else {
            return convertToDtoList(airportFlights);
        }
    }

    public List<AirportFlightDto> getAirportFlightsByFromOrToAirportId(Integer airportId) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllByFrom1_AirportIdOrTo_AirportId(airportId, airportId);
        return convertToDtoList(airportFlights);
    }

    public void deleteAirportFlightWhichConnectWithFlightToDelete(Integer flightId) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllByFlight_FlightId(flightId);
        for (int i = 0; i < airportFlights.size(); i++) {
            airportFlightRepository.deleteById((airportFlights.get(i)).getAirportFlightId());
        }
    }

    public void createAirportFlight(AirportFlightDto airportFlightDto) {
        AirportFlight newAirportFlight = convertToAirportFlight(airportFlightDto);
        airportFlightRepository.save(newAirportFlight);
    }

    public void deleteAirportFlight(AirportFlightDto airportFlightDto) {
        airportFlightRepository.deleteById(airportFlightDto.getAirportFlightId());
    }

    public AirportFlightDto updateAirportFlight(AirportFlightDto airportFlightDto) {
        boolean isAirportFlightExist = airportFlightRepository.existsById(airportFlightDto.getAirportFlightId());
        if (isAirportFlightExist) {
            AirportFlight airportFlight = convertToAirportFlight(airportFlightDto);
            airportFlightRepository.save(airportFlight);
            return convertToAirportFlightDto(airportFlight);
        } else {
            throw new EntityNotFoundException("Airport - Flight Not Found");
        }
    }

//    public List<AirportFlightDto> getAirportFlightByFlightId(Integer flightId){
//        List<AirportFlight> airportFlights = airportFlightRepository.findAllByFlight_FlightId(flightId);
//        return convertToDtoList(airportFlights);
//    }

    public AirportFlightDto convertToAirportFlightDto(AirportFlight airportFlight) {
        return modelMapper.map(airportFlight, AirportFlightDto.class);
    }

    public AirportFlight convertToAirportFlight(AirportFlightDto airportFlightDto) {
        return modelMapper.map(airportFlightDto, AirportFlight.class);
    }

    public List<AirportFlightDto> convertToDtoList(List<AirportFlight> airportFlights) {
        TypeToken<List<AirportFlightDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(airportFlights, typeToken.getType());
    }
}

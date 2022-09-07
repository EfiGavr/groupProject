package groupproject.projectx.services;

import groupproject.projectx.dtos.AirportFlightDto;
import groupproject.projectx.model.AirportFlight;
import groupproject.projectx.repository.AirportFlightRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AirportFlightService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AirportFlightRepository airportFlightRepository;

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
        return new AirportFlightDto();
    }

    public List<AirportFlightDto> getAirportFlightByAirportNameDeparture(String airportname) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByFrom1_AirportnameIs(airportname);
        return convertToDtoList(airportFlights);
    }

    public List<AirportFlightDto> getAirportFlightByAirportNameDestination(String airportname) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByTo_AirportnameIs(airportname);
        return convertToDtoList(airportFlights);
    }

    public List<AirportFlightDto> getAirportFlightByCountryDeparture(String country) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByFrom1_CountryIs(country);
        return convertToDtoList(airportFlights);
    }

    public List<AirportFlightDto> getAirportFlightByCountryDestination(String country) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByTo_CountryIs(country);
        return convertToDtoList(airportFlights);
    }

    public List<AirportFlightDto> getAirportFlightByCityDeparture(String city) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByFrom1_CityIs(city);
        return convertToDtoList(airportFlights);
    }

    public List<AirportFlightDto> getAirportFlightByCityDestination(String city) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByTo_CityIs(city);
        return convertToDtoList(airportFlights);
    }

    public List<AirportFlightDto> getAirportFlightByDepartureArrivalDateAndByDepartureArrivalCountry(LocalDateTime departureStartDate, String countryDeparture, String countryArrival) {
        List<AirportFlight> airportFlights = airportFlightRepository.findAllAirportFlightsByFlight_DepartureBetweenAndFrom1_CountryIsAndTo_CountryIs(departureStartDate, departureStartDate.plusHours(24).minusSeconds(1), countryDeparture, countryArrival);
        return convertToDtoList(airportFlights);
    }

    public List<AirportFlightDto> getAirportFlightsByFromOrToAirportId(Integer airportId){
        List<AirportFlight> airportFlights = airportFlightRepository.findAllByFrom1_AirportIdOrTo_AirportId(airportId, airportId);
        return convertToDtoList(airportFlights);
    }

    public AirportFlightDto convertToAirportFlightDto(AirportFlight airportFlight) {
        return modelMapper.map(airportFlight, AirportFlightDto.class);
    }

    public List<AirportFlightDto> convertToDtoList(List<AirportFlight> airportFlights) {
        TypeToken<List<AirportFlightDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(airportFlights, typeToken.getType());
    }
}

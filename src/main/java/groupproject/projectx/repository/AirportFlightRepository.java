package groupproject.projectx.repository;


import groupproject.projectx.model.AirportFlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AirportFlightRepository extends JpaRepository<AirportFlight, Integer> {

    List<AirportFlight> findAllAirportFlightsByTo_AirportnameIs(String airportname);

    List<AirportFlight> findAllAirportFlightsByFrom1_AirportnameIs(String airportname);

    List<AirportFlight> findAllAirportFlightsByFrom1_CountryIs(String country);

    List<AirportFlight> findAllAirportFlightsByTo_CountryIs(String country);

    List<AirportFlight> findAllAirportFlightsByFrom1_CityIs(String country);

    List<AirportFlight> findAllAirportFlightsByTo_CityIs(String country);

    List<AirportFlight> findAllByFrom1_AirportIdOrTo_AirportId(Integer airportId, Integer airportId1);

    List<AirportFlight> findAllAirportFlightsByFlight_DepartureBetweenAndFrom1_CountryIsAndTo_CountryIs(LocalDateTime departureStartDate, LocalDateTime departureEndDate, String countryDeparture, String countryArrival);

    List<AirportFlight> findAllByFlight_FlightId(Integer flightId);


}

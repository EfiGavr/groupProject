package groupproject.projectx.services;

import groupproject.projectx.dtos.PilotFlightDto;
import groupproject.projectx.model.Airport;
import groupproject.projectx.model.PilotFlight;
import groupproject.projectx.repository.PilotFlightRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class PilotFlightService {

    @Autowired
    PilotFlightRepository pilotFlightRepository;

    @Autowired
    ModelMapper modelMapper;


    public List<PilotFlightDto> getAllPilotFlights(){
        return convertToDtoList(pilotFlightRepository.findAll());
    }

    public PilotFlightDto getPilotFlightById(Integer pilotFlightId){
        Optional<PilotFlight> pilotFlightOptional = pilotFlightRepository.findById(pilotFlightId);
        if (pilotFlightOptional.isPresent()) {
            PilotFlight pilotFlight = pilotFlightOptional.get();
            return convertToDto(pilotFlight);
        } else {
            throw new EntityNotFoundException("PilotFlight Not Found");
        }
    }

    public List<PilotFlightDto> getPilotFlightsFromPilotId(Integer pilotId) {
        List<PilotFlightDto> pilotFlightDtos = convertToDtoList(pilotFlightRepository.findAllByPilot_PilotId(pilotId));
        return pilotFlightDtos;
    }

    public List<PilotFlightDto> getPilotFlightsFromFlightId(Integer flightId){
        List<PilotFlightDto> pilotFlightDtoList = convertToDtoList(pilotFlightRepository.findAllByFlight_FlightId(flightId));
        return pilotFlightDtoList;
    }

    public PilotFlightDto convertToDto(PilotFlight pilotFlight) {
        return modelMapper.map(pilotFlight, PilotFlightDto.class);
    }

    public List<PilotFlightDto> convertToDtoList(List<PilotFlight> pilotFlights) {
        TypeToken<List<PilotFlightDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(pilotFlights, typeToken.getType());
    }
}

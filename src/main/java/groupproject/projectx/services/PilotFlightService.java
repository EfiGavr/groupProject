package groupproject.projectx.services;

import groupproject.projectx.dtos.AirportFlightDto;
import groupproject.projectx.dtos.PilotFlightDto;
import groupproject.projectx.model.PilotFlight;
import groupproject.projectx.repository.PilotFlightRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotFlightService {

    @Autowired
    PilotFlightRepository pilotFlightRepository;

    @Autowired
    ModelMapper modelMapper;


    public List<PilotFlightDto> getPilotFlightsFromPilotId(Integer pilotId) {
        List<PilotFlightDto> pilotFlightDtos = convertToDtoList(pilotFlightRepository.findAllByPilot_PilotId(pilotId));
        return pilotFlightDtos;
    }

    public PilotFlightDto convertToDto(PilotFlight pilotFlight) {
        return modelMapper.map(pilotFlight, PilotFlightDto.class);
    }

    public List<PilotFlightDto> convertToDtoList(List<PilotFlight> pilotFlights) {
        TypeToken<List<AirportFlightDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(pilotFlights, typeToken.getType());
    }
}

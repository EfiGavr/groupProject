package groupproject.projectx.services;

import groupproject.projectx.dtos.PilotFlightDto;
import groupproject.projectx.model.PilotFlight;
import groupproject.projectx.repository.PilotFlightRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PilotFlightService {

    @Autowired
    PilotFlightRepository pilotFlightRepository;

    @Autowired
    ModelMapper modelMapper;


    public List<PilotFlightDto> getAllPilotFlights() {
        return convertToDtoList(pilotFlightRepository.findAll());
    }

    public PilotFlightDto getPilotFlightById(Integer pilotFlightId) {
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
        if (pilotFlightDtos.isEmpty()) {
            throw new EntityNotFoundException("PilotFlight Not Found For This Pilot Id");
        } else {
            return pilotFlightDtos;
        }
    }

    public List<PilotFlightDto> getPilotFlightsFromFlightId(Integer flightId) {
        List<PilotFlightDto> pilotFlightDtoList = convertToDtoList(pilotFlightRepository.findAllByFlight_FlightId(flightId));
        if (pilotFlightDtoList.isEmpty()) {
            throw new EntityNotFoundException("PilotFlight Not Found For This Flight Id");
        } else {
            return pilotFlightDtoList;
        }
    }

    public void createPilotFlight(PilotFlightDto pilotFlightDto) {
        PilotFlight newPilotFlight = convertToPilotFlight(pilotFlightDto);
        pilotFlightRepository.save(newPilotFlight);
    }

    public PilotFlightDto updatePilotFlight(PilotFlightDto pilotFlightDto) {
        boolean isPilotFlightExist = pilotFlightRepository.existsById(pilotFlightDto.getPilotFlightId());
        if (isPilotFlightExist) {
            PilotFlight pilotFlight = convertToPilotFlight(pilotFlightDto);
            pilotFlightRepository.save(pilotFlight);
            return convertToDto(pilotFlight);
        } else {
            throw new EntityNotFoundException("Pilot - Flight Not Found");
        }
    }

    public void deletePilotFlight(PilotFlightDto pilotFlightDto) {
        pilotFlightRepository.deleteById(pilotFlightDto.getPilotFlightId());
    }

    public PilotFlightDto convertToDto(PilotFlight pilotFlight) {
        return modelMapper.map(pilotFlight, PilotFlightDto.class);
    }

    public PilotFlight convertToPilotFlight(PilotFlightDto pilotFlightDto) {
        return modelMapper.map(pilotFlightDto, PilotFlight.class);
    }

    public List<PilotFlightDto> convertToDtoList(List<PilotFlight> pilotFlights) {
        TypeToken<List<PilotFlightDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(pilotFlights, typeToken.getType());
    }
}

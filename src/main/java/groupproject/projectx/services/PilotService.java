package groupproject.projectx.services;

import groupproject.projectx.dtos.PilotDto;
import groupproject.projectx.model.Pilot;
import groupproject.projectx.repository.PilotFlightRepository;
import groupproject.projectx.repository.PilotRepository;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PilotService {

    @Autowired
    PilotRepository pilotRepository;

    @Autowired
    PilotFlightRepository pilotFlightRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<PilotDto> getAllPilots() {
        return convertToDtoList(pilotRepository.findAll());
    }

    public PilotDto getPilotById(Integer pilotId) {
        Optional<Pilot> pilotOptional = pilotRepository.findById(pilotId);
        if (pilotOptional.isPresent()) {
            Pilot pilot = pilotOptional.get();
            return convertToDto(pilot);
        } else {
            throw new EntityNotFoundException("Pilot Not Found");
        }
    }

    public List<PilotDto> getPilotsByFname(String fname) {
        List<PilotDto> pilots = convertToDtoList(pilotRepository.findAllByFname(fname));
        if (pilots.isEmpty()) {
            throw new EntityNotFoundException("No Pilot Found For This First Name");
        } else {
            return pilots;
        }
    }

    public List<PilotDto> getPilotsByLname(String lname) {
        List<PilotDto> pilots = convertToDtoList(pilotRepository.findAllByLname(lname));
        if (pilots.isEmpty()) {
            throw new EntityNotFoundException("No Pilot Found For This Last Name");
        } else {
            return pilots;
        }
    }

    public List<PilotDto> getPilotsByContactNumber(String contactNumber) {
        List<PilotDto> pilots = convertToDtoList(pilotRepository.findAllByContactNumber(contactNumber));
        if (pilots.isEmpty()) {
            throw new EntityNotFoundException("No Pilot Found For This Contact Number");
        } else {
            return pilots;
        }
    }

    //Something needs changes in this Method
    public PilotDto getPilotByLicenceNumber(Integer licenceNumber) {
        Pilot pilot = pilotRepository.findByLicenceNumber(licenceNumber);
        if (pilot != null) {
            return convertToDto(pilot);
        } else {
            throw new EntityNotFoundException("No Pilot Found For This Licence Number");
        }
    }

    public Boolean existRelatedPilotFlight(Integer pilotId) {
        boolean exist = false;
        if (pilotFlightRepository.existsByPilot_PilotId(pilotId)) {
            exist = true;
        }
        return exist;
    }

    public void createPilot(PilotDto pilotDto) {
        Pilot pilot = convertToPilot(pilotDto);
        pilotRepository.save(pilot);
    }

    public void deletePilot(PilotDto pilotDto) {
        pilotRepository.deleteById(pilotDto.getPilotId());
    }

    public PilotDto updatePilot(PilotDto pilotDto) {
        Optional<Pilot> pilotOptional = pilotRepository.findById(pilotDto.getPilotId());
        if (pilotOptional.isPresent()) {
            Pilot pilot = convertToPilot(pilotDto);
            pilotRepository.save(pilot);
            return convertToDto(pilot);
        } else {
            throw new EntityNotFoundException("Pilot Not Found");
        }
    }

    public PilotDto convertToDto(Pilot pilot) {
        return modelMapper.map(pilot, PilotDto.class);
    }

    public Pilot convertToPilot(PilotDto pilotDto) {
        return modelMapper.map(pilotDto, Pilot.class);
    }

    public List<PilotDto> convertToDtoList(List<Pilot> pilots) {
        TypeToken<List<PilotDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(pilots, typeToken.getType());
    }
}

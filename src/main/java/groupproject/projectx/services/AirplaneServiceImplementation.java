
package groupproject.projectx.services;

import groupproject.projectx.dtos.AirplaneDto;
import groupproject.projectx.model.Airplane;
import groupproject.projectx.repository.AirplaneRepository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImplementation implements AirplaneService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AirplaneRepository airplaneRepository;

    @Override
    public List<AirplaneDto> getAllAirplanes() {
        return convertToDtoList(airplaneRepository.findAll());
    }

    @Override
    public AirplaneDto getAirplaneById(Integer id) {
        //get optional airplane
        Optional<Airplane> airplaneOptional = airplaneRepository.findById(id);
        //if it exists
        if (airplaneOptional.isPresent()) {
            // get this airplane
            Airplane airplane = airplaneOptional.get();
            //convert it to airplane dto  and return it
            return convertToAirplaneDto(airplane);
        } else {
            throw new EntityNotFoundException("Airplane Not Found");
        }
    }

    @Override
    public List<AirplaneDto> getAirplanesByManufacture(String manufacture) {
        List<AirplaneDto> airplanes = convertToDtoList(airplaneRepository.findByManufactureContaining(manufacture));
        if (airplanes.isEmpty()) {
            throw new EntityNotFoundException("No Airplanes Found With This Manufacture");
        } else {
            return airplanes;
        }
    }

    @Override
    public List<AirplaneDto> getAirplanesByModelNumber(String modelNumber) {
        List<AirplaneDto> airplanes = convertToDtoList(airplaneRepository.findByModelNumber(modelNumber));
        if (airplanes.isEmpty()) {
            throw new EntityNotFoundException("No Airplanes Found With This Model Number");
        } else {
            return airplanes;
        }
    }

    @Override
    public List<AirplaneDto> getAirplanesByCapacity(Integer capacity) {
        List<AirplaneDto> airplanes = convertToDtoList(airplaneRepository.findByCapacity(capacity));
        if (airplanes.isEmpty()) {
            throw new EntityNotFoundException("No Airplanes Found With This Capacity");
        } else {
            return airplanes;
        }
    }

    @Override
    public void createAirplane(AirplaneDto airplaneDto) {
        Airplane newAirplane = convertToAirplane(airplaneDto);
        airplaneRepository.save(newAirplane);
    }

    @Override
    public void deleteAirplane(AirplaneDto airplaneDto) {
        airplaneRepository.deleteById(airplaneDto.getAirplaneId());
    }

    @Override
    public AirplaneDto updateAirplane(AirplaneDto updatedAirplaneDto) {
        boolean isAirplaneExist = airplaneRepository.existsById(updatedAirplaneDto.getAirplaneId());
        if (isAirplaneExist) {
            Airplane airplane = convertToAirplane(updatedAirplaneDto);
            airplaneRepository.save(airplane);
            return convertToAirplaneDto(airplane);
        } else {
            throw new EntityNotFoundException("Airplane Not Found");
        }
    }

    @Override
    public AirplaneDto convertToAirplaneDto(Airplane airplane) {
        return modelMapper.map(airplane, AirplaneDto.class);
    }

    @Override
    public Airplane convertToAirplane(AirplaneDto airplaneDto) {
        return modelMapper.map(airplaneDto, Airplane.class);
    }

    @Override
    public List<AirplaneDto> convertToDtoList(List<Airplane> airplanes) {
        TypeToken<List<AirplaneDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(airplanes, typeToken.getType());
    }
}

    

    


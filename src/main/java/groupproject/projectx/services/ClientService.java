package groupproject.projectx.services;

import groupproject.projectx.model.Client;
import groupproject.projectx.dtos.ClientDto;
import groupproject.projectx.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    ClientRepository clientRepository;
    
    public List<ClientDto> getAllClients() {
        return convertToDtoList(clientRepository.findAll());
    }
    
    public List<ClientDto> getAllClientsByRole(String role) {
        return convertToDtoList(clientRepository.findAllByRole(role));
    }
    
    public void createClient(ClientDto clientDto){
        Client newClient = convertToClient(clientDto);
        clientRepository.save(newClient);
    }
    
    public void deleteClient(ClientDto clientDto) {
        clientRepository.deleteById(convertToClient(clientDto).getClientId());
    }
    
    public ClientDto updateClient(ClientDto updatedClientDto) {
        Optional<Client> clientOptional = clientRepository.findById(updatedClientDto.getClientId());
        if (clientOptional.isPresent()) {
            Client client = convertToClient(updatedClientDto);
            clientRepository.save(client);
            return updatedClientDto;
        } else {
            throw new EntityNotFoundException ("Client Not Found");
        }
    }
    
    public Client convertToClient(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }
    
    public List<ClientDto> convertToDtoList(List<Client> clients) {
        TypeToken<List<ClientDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(clients, typeToken.getType());
    }
}

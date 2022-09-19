package groupproject.projectx.services;


import groupproject.projectx.dtos.AdminDto;
import groupproject.projectx.model.Admin;
import groupproject.projectx.model.Client;
import groupproject.projectx.dtos.ClientDto;
import groupproject.projectx.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import groupproject.projectx.repository.ClientTicketRepository;
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

    @Autowired
    ClientTicketRepository clientTicketRepository;


    public ClientDto getClientById(Integer clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return convertToClientDto(client);
        } else {
            throw new EntityNotFoundException("Client Not Found");
        }
    }

    public List<ClientDto> getAllClients() {
        return convertToDtoList(clientRepository.findAll());
    }

    public List<ClientDto> getAllClientsByRole(String role) {
        List<ClientDto> clientDtos = convertToDtoList(clientRepository.findAllByRole(role));
        if (clientDtos.isEmpty()) {
            throw new EntityNotFoundException("No Clients Found For This Role");
        } else {
            return clientDtos;
        }
    }

    public List<ClientDto> getAllClientsByTelephone(String telephoneNumber) {
        List<ClientDto> clientDtos = convertToDtoList(clientRepository.findAllByTelephoneNumber(telephoneNumber));
        if (clientDtos.isEmpty()) {
            throw new EntityNotFoundException("No Clients Found For This Telephone Number");
        } else {
            return clientDtos;
        }
    }

    public List<ClientDto> getAllClientsByEmail(String email) {
        List<ClientDto> clientDtos = convertToDtoList(clientRepository.findAllByEmail(email));
        if (clientDtos.isEmpty()) {
            throw new EntityNotFoundException("No Clients Found For This Email");
        } else {
            return clientDtos;
        }
    }

    public List<ClientDto> getAllClientsByFname(String fname) {
        List<ClientDto> clientDtos = convertToDtoList(clientRepository.findAllByFname(fname));
        if (clientDtos.isEmpty()) {
            throw new EntityNotFoundException("No Clients Found For This First Name");
        } else {
            return clientDtos;
        }
    }

    public List<ClientDto> getAllClientsByLname(String lname) {
        List<ClientDto> clientDtos = convertToDtoList(clientRepository.findAllByLname(lname));
        if (clientDtos.isEmpty()) {
            throw new EntityNotFoundException("No Clients Found For This Last Name");
        } else {
            return clientDtos;
        }
    }

    public Boolean existRelatedClientTicket(Integer clientId) {
        boolean exist = false;
        if (clientTicketRepository.existsByClient_ClientId(clientId)) {
            exist = true;
        }
        return exist;
    }



    public void createClient(ClientDto clientDto) {
        Client newClient = convertToClient(clientDto);
        clientRepository.save(newClient);
    }

    public void deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId);
    }

    public ClientDto updateClient(ClientDto updatedClientDto) {
        Optional<Client> clientOptional = clientRepository.findById(updatedClientDto.getClientId());
        if (clientOptional.isPresent()) {
            Client client = convertToClient(updatedClientDto);
            clientRepository.save(client);
            return updatedClientDto;
        } else {
            throw new EntityNotFoundException("Client Not Found");
        }
    }

    public ClientDto getClientByCredentials(String username, String password) {
        Client client = clientRepository.findByUsernameAndPassword(username, password);
        if (client == null){
            throw new IllegalArgumentException("Client Did Not Found");
        }else{
            return convertToClientDto(client);
        }
    }

    public Client convertToClient(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

    public ClientDto convertToClientDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }

    public List<ClientDto> convertToDtoList(List<Client> clients) {
        TypeToken<List<ClientDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(clients, typeToken.getType());
    }
}

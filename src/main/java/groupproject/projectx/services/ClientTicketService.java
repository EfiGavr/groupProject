package groupproject.projectx.services;

import groupproject.projectx.dtos.ClientTicketDto;
import groupproject.projectx.model.Client;
import groupproject.projectx.model.ClientTicket;
import groupproject.projectx.model.Ticket;
import groupproject.projectx.repository.ClientRepository;
import groupproject.projectx.repository.ClientTicketRepository;
import groupproject.projectx.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientTicketService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClientTicketRepository clientTicketRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientTicketDto> getAllClientTicket() {
        List<ClientTicket> clientTickets = clientTicketRepository.findAll();
        return convertToDtoList(clientTickets);
    }

    public ClientTicketDto getClientTicketDtoById(Integer clientTicketId) {
        //get optional flight
        Optional<ClientTicket> clientTicketOptional = clientTicketRepository.findById(clientTicketId);
        //if it exists
        if (clientTicketOptional.isPresent()) {
            // get this flight
            ClientTicket clientTicket = clientTicketOptional.get();
            //convert it to flight dto  and return it
            return convertToClientTicketDto(clientTicket);
        }
        throw new EntityNotFoundException("Client - Ticket Not Found");
    }

    public List<ClientTicketDto> getClientTicketByTicketId(Integer ticketId) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllClientTicketByTicket_TicketIdIs(ticketId);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client found For This Ticket Id");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public List<ClientTicketDto> getClientTicketByFare(BigDecimal fare) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllClientTicketByTicket_FareIs(fare);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client - Ticket found For This Ticket Fare");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public List<ClientTicketDto> getClientTicketByFlightId(Integer flightId) {
        List<ClientTicket> clientTickets = clientTicketRepository.findByTicket_FlightTicketId_FlightId(flightId);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client found For This Flight Id");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public List<ClientTicketDto> getClientTicketDtoByClientId(Integer clientId) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllClientTicketByClient_ClientIdIs(clientId);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client found For This Client Id");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public List<ClientTicket> getClientTicketByClientId(Integer clientId) {
        List<ClientTicket> clientTickets = new ArrayList<>();
        try {
            clientTickets = clientTicketRepository.findAllClientTicketByClient_ClientIdIs(clientId);
        } catch (Exception ex) {
            // TODO Add logger here
        }
        return clientTickets;
    }

    public List<ClientTicketDto> getClientTicketByClientTelephone(String telNumber) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllClientTicketByClient_TelephoneNumberIs(telNumber);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client found For This Client's Telephone Number");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public List<ClientTicketDto> getClientTicketByClientEmail(String email) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllClientTicketByClient_EmailIs(email);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client found For This Client's E-Mail");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public List<ClientTicketDto> getClientTicketByClientFname(String fname) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllClientTicketByClient_FnameIs(fname);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client found For This Client's First Name");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public List<ClientTicketDto> getClientTicketByClientLname(String lname) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllClientTicketByClient_LnameIs(lname);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client found For This Client's Last Name");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public List<ClientTicketDto> getClientTicketByRole(String role) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllClientTicketByClient_RoleIs(role);
        if (clientTickets.isEmpty()) {
            throw new EntityNotFoundException("No Client - Ticket found For This Role");
        } else {
            return convertToDtoList(clientTickets);
        }
    }

    public void deleteClientTicketWhichConnectWithTicketToDelete(Integer ticketId) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllByTicket_TicketId(ticketId);
        for (int i = 0; i < clientTickets.size(); i++) {
            clientTicketRepository.deleteById((clientTickets.get(i)).getClientTicketId());
        }
    }

    public List<ClientTicket> findClientTicketWhichConnectWithTicketToDelete(Integer ticketId) {
        List<ClientTicket> clientTickets = clientTicketRepository.findAllByTicket_TicketId(ticketId);
        List<ClientTicketDto> clientTicketDtos = convertToDtoList(clientTickets);
        return clientTickets;
    }

    public ClientTicket createClientTicket(Integer clientId, Integer ticketId) {
        ClientTicket newClientTicket = new ClientTicket();
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        Ticket ticket = new Ticket();
        Client client = new Client();
        if ((ticketOptional.isPresent() && (clientOptional.isPresent()))) {
            ticket = ticketOptional.get();
            client = clientOptional.get();
            newClientTicket.setTicket(ticket);
            newClientTicket.setClient(client);
            clientTicketRepository.save(newClientTicket);
            ticket.setReserved(true);
            ticketRepository.save(ticket);
            return newClientTicket;
        } else {
            throw new EntityNotFoundException(" Not ticket or client found");
        }
    }

    public void deleteClientTicket(Integer clientTicketId) {
        clientTicketRepository.deleteById(clientTicketId);
    }

    //METHODS THAT ARE NOT GOING TO BE USED

//    public void deleteClientTicket(ClientTicketDto clientTicketDto) {
//        int clientId = clientTicketDto.getClient().getClientId();
//        List<ClientTicket> clientTickets = clientTicketService.getClientTicketByClientId(clientId);
//        for(int i = 0; i < clientTickets.size(); i++){
//            Integer ticketId = clientTickets.get(i).getTicket().getTicketId();
//            Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
//            if (ticketOptional.isPresent()) {
//                Ticket ticket = ticketOptional.get();
//                ticket.setReserved(false);
//                ticketRepository.save(ticket);
//            }
//        }
//        clientTicketRepository.deleteById(clientTicketDto.getClientTicketId());
//    }

//    public ClientTicketDto updateClientTicket(ClientTicketDto clientTicketDto) {
//        boolean isClientTicketExist = clientTicketRepository.existsById(clientTicketDto.getClientTicketId());
//        if (isClientTicketExist) {
//            ClientTicket clientTicket = convertToClientTicket(clientTicketDto);
//            clientTicketRepository.save(clientTicket);
//            return convertToClientTicketDto(clientTicket);
//        } else {
//            throw new EntityNotFoundException("Client - Ticket Not Found");
//        }
//    }

    public ClientTicketDto convertToClientTicketDto(ClientTicket clientTicket) {
        return modelMapper.map(clientTicket, ClientTicketDto.class);
    }

    public ClientTicket convertToClientTicket(ClientTicketDto clientTicketDto) {
        return modelMapper.map(clientTicketDto, ClientTicket.class);
    }

    public List<ClientTicketDto> convertToDtoList(List<ClientTicket> clientTickets) {
        TypeToken<List<ClientTicketDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(clientTickets, typeToken.getType());
    }
}

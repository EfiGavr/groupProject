
package groupproject.projectx.services;


import groupproject.projectx.dtos.TicketDto;
import groupproject.projectx.model.ClientTicket;
import groupproject.projectx.model.Ticket;
import groupproject.projectx.repository.TicketRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClientTicketService clientTicketService;

    public List<TicketDto> getAllTickets() {
        return convertToDtoList(ticketRepository.findAll());
    }

    public TicketDto getTicketById(Integer ticketId) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            return convertToTicketDto(ticket);
        } else {
            throw new EntityNotFoundException("Ticket Not Found");
        }
    }

    public List<TicketDto> getTicketsByFare(BigDecimal fare) {
        List<TicketDto> ticketDtos = convertToDtoList(ticketRepository.findByFare(fare));
        if (ticketDtos.isEmpty()) {
            throw new EntityNotFoundException("No Tickets Found For This Fare");
        } else {
            return ticketDtos;
        }
    }

    public List<TicketDto> getTicketsByFlightId(Integer flightId) {
        List<TicketDto> ticketDtos = convertToDtoList(ticketRepository.findByFlightTicketId_FlightId(flightId));
        if (ticketDtos.isEmpty()) {
            throw new EntityNotFoundException("No Tickets Found For This Flight");
        } else {
            return ticketDtos;
        }
    }

    public void createTicket(TicketDto ticketDto) {
        Ticket newTicket = convertToTicket(ticketDto);
        ticketRepository.save(newTicket);
    }

    public TicketDto updateTicket(TicketDto updatedTicketDto) {
        boolean isTicketExist = ticketRepository.existsById(updatedTicketDto.getTicketId());
        if (isTicketExist) {
            Ticket ticket = convertToTicket(updatedTicketDto);
            ticketRepository.save(ticket);
            return convertToTicketDto(ticket);
        } else {
            throw new EntityNotFoundException("Ticket Not Found");
        }
    }

    public void deleteTicket(TicketDto ticketDto) {
        ticketRepository.deleteById(ticketDto.getTicketId());
    }


    public void deleteTicketByClientId(Integer clientId) {
        List<ClientTicket> clientTickets = clientTicketService.getClientTicketByClientId(clientId);
        for (int i = 0; i < clientTickets.size(); i++) {
            //Get ticketId from every clientTicket
            Integer ticketId = clientTickets.get(i).getTicket().getTicketId();
            //Find and Delete ticket with this id
            ticketRepository.deleteById(ticketId);
        }
    }

    public TicketDto convertToTicketDto(Ticket ticket) {
        return modelMapper.map(ticket, TicketDto.class);
    }

    public Ticket convertToTicket(TicketDto ticketDto) {
        return modelMapper.map(ticketDto, Ticket.class);
    }


    public List<TicketDto> convertToDtoList(List<Ticket> tickets) {
        TypeToken<List<TicketDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(tickets, typeToken.getType());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.services;

import groupproject.projectx.model.Ticket;
import java.util.Optional;

/**
 *
 * @author Vaggelis
 */
public interface TicketServiceInterface {
    
       Optional<Ticket> findById(Integer id);
    
}

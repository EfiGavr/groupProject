/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "passengertoticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passengertoticket.findAll", query = "SELECT p FROM Passengertoticket p"),
    @NamedQuery(name = "Passengertoticket.findByPassengerToticketid", query = "SELECT p FROM Passengertoticket p WHERE p.passengerToticketid = :passengerToticketid")})
public class Passengertoticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "passengerToticket_id")
    private Integer passengerToticketid;
    @JoinColumn(name = "passenger", referencedColumnName = "passenger_id")
    @ManyToOne
    private Passenger passenger;
    @JoinColumn(name = "ticket", referencedColumnName = "ticket_id")
    @ManyToOne
    private Ticket ticket;

    public Passengertoticket() {
    }

    public Passengertoticket(Integer passengerToticketid) {
        this.passengerToticketid = passengerToticketid;
    }

    public Integer getPassengerToticketid() {
        return passengerToticketid;
    }

    public void setPassengerToticketid(Integer passengerToticketid) {
        this.passengerToticketid = passengerToticketid;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passengerToticketid != null ? passengerToticketid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passengertoticket)) {
            return false;
        }
        Passengertoticket other = (Passengertoticket) object;
        if ((this.passengerToticketid == null && other.passengerToticketid != null) || (this.passengerToticketid != null && !this.passengerToticketid.equals(other.passengerToticketid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passengertoticket{passengerToticketid=").append(passengerToticketid);
        sb.append(", passenger=").append(passenger);
        sb.append(", ticket=").append(ticket);
        sb.append('}');
        return sb.toString();
    }

  
    
}

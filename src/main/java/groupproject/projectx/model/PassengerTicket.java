package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

@Entity
@Table(name = "passenger_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PassengerTicket.findAll", query = "SELECT p FROM PassengerTicket p")})
public class PassengerTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "passenger_ticket_id")
    private Integer passengerTicketId;
    @JoinColumn(name = "passenger", referencedColumnName = "passenger_id")
    @ManyToOne
    @JsonBackReference
    private Passenger passenger;
    @JoinColumn(name = "ticket", referencedColumnName = "ticket_id")
    @ManyToOne
    @JsonBackReference
    private Ticket ticket;

    public PassengerTicket() {
    }

    public PassengerTicket(Integer passengerTicketId) {
        this.passengerTicketId = passengerTicketId;
    }

    public Integer getPassengerTicketId() {
        return passengerTicketId;
    }

    public void setPassengerTicketId(Integer passengerTicketId) {
        this.passengerTicketId = passengerTicketId;
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
        hash += (passengerTicketId != null ? passengerTicketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PassengerTicket)) {
            return false;
        }
        PassengerTicket other = (PassengerTicket) object;
        if ((this.passengerTicketId == null && other.passengerTicketId != null) || (this.passengerTicketId != null && !this.passengerTicketId.equals(other.passengerTicketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.PassengerTicket[ passengerTicketId=" + passengerTicketId + " ]";
    }

}

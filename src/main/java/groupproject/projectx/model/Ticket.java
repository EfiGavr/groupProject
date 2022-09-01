package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fare")
    private BigDecimal fare;

    @JoinColumn(name = "flight_ticket_id", referencedColumnName = "flight_id")
    @ManyToOne
    @JsonBackReference
    private Flight flightTicketId;

    @OneToMany(mappedBy = "ticket")
    @JsonManagedReference
    private Set<ClientTicket> clientTicketSet;

    public Ticket() {
    }

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public Flight getFlightTicketId() {
        return flightTicketId;
    }

    public void setFlightTicketId(Flight flightTicketId) {
        this.flightTicketId = flightTicketId;
    }

    @XmlTransient
    public Set<ClientTicket> getClientTicketSet() {
        return clientTicketSet;
    }

    public void setClientTicketSet(Set<ClientTicket> clientTicketSet) {
        this.clientTicketSet = clientTicketSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.Ticket[ ticketId=" + ticketId + " ]";
    }

}


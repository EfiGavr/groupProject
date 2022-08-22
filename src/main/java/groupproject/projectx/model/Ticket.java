/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTicketId", query = "SELECT t FROM Ticket t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "Ticket.findByFrom", query = "SELECT t FROM Ticket t WHERE t.from = :from"),
    @NamedQuery(name = "Ticket.findByTo", query = "SELECT t FROM Ticket t WHERE t.to = :to"),
    @NamedQuery(name = "Ticket.findByFare", query = "SELECT t FROM Ticket t WHERE t.fare = :fare")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Size(max = 45)
    @Column(name = "from")
    private String from;
    @Size(max = 45)
    @Column(name = "to")
    private String to;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fare")
    private BigDecimal fare;
    @OneToMany(mappedBy = "ticket")
    private Set<Passengertoticket> passengertoticketSet;

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    @XmlTransient
    public Set<Passengertoticket> getPassengertoticketSet() {
        return passengertoticketSet;
    }

    public void setPassengertoticketSet(Set<Passengertoticket> passengertoticketSet) {
        this.passengertoticketSet = passengertoticketSet;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket{ticketId=").append(ticketId);
        sb.append(", from=").append(from);
        sb.append(", to=").append(to);
        sb.append(", fare=").append(fare);
        sb.append(", passengertoticketSet=").append(passengertoticketSet);
        sb.append('}');
        return sb.toString();
    }

  
    
}

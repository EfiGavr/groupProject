package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

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
@Getter
@Setter
@ToString(exclude = {"clientTicketSet"})
@AllArgsConstructor
@NoArgsConstructor
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

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    @XmlTransient
    public Set<ClientTicket> getClientTicketSet() {
        return clientTicketSet;
    }

    public void setClientTicketSet(Set<ClientTicket> clientTicketSet) {
        this.clientTicketSet = clientTicketSet;
    }

}


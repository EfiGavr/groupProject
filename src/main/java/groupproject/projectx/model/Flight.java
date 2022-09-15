package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "flight")
@Getter
@Setter
@ToString(exclude = {"ticketSet"})
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "flight_id")
    private Integer flightId;

    @JsonManagedReference
    @OneToMany(mappedBy = "flightTicketId")
    private Set<Ticket> ticketSet;

    @Column(name = "departure")
    private LocalDateTime departure;

    @Column(name = "arrival")
    private LocalDateTime arrival;

    public Flight(Integer flightId) {
        this.flightId = flightId;
    }

//    @XmlTransient
//    public Set<ClientFlight> getClientFlightSet() {
//        return clientFlightSet;
//    }
//
//    public void setClientFlightSet(Set<ClientFlight> clientFlightSet) {
//        this.clientFlightSet = clientFlightSet;
//    }

    @XmlTransient
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

}

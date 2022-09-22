package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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
@Table(name = "airport_flight")
@Getter
@Setter
@ToString(exclude = {"from1", "to", "flight"})
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "AirportFlight.findAll", query = "SELECT a FROM AirportFlight a")})
public class AirportFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "airport_flight_id")
    private Integer airportFlightId;

    @JoinColumn(name = "[from]", referencedColumnName = "airport_id")
    @ManyToOne
    @JsonBackReference
    private Airport from1;

    @JoinColumn(name = "[to]", referencedColumnName = "airport_id")
    @ManyToOne
    @JsonBackReference
    private Airport to;

    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    @JsonBackReference
    private Flight flight;

    public AirportFlight(Airport from1, Airport to, Flight flight) {
        this.from1 = from1;
        this.to = to;
        this.flight = flight;
    }

    public AirportFlight(Integer airportFlightId) {
        this.airportFlightId = airportFlightId;
    }


}

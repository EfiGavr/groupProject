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
@Table(name = "airport_flight")
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
    
    @JoinColumn(name = "from", referencedColumnName = "airport_id")
    @ManyToOne
    @JsonBackReference
    private Airport from1;
    
    @JoinColumn(name = "to", referencedColumnName = "airport_id")
    @ManyToOne
    @JsonBackReference
    private Airport to;
    
    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    @JsonBackReference
    private Flight flight;

    public AirportFlight() {
    }

    public AirportFlight(Integer airportFlightId) {
        this.airportFlightId = airportFlightId;
    }

    public Integer getAirportFlightId() {
        return airportFlightId;
    }

    public void setAirportFlightId(Integer airportFlightId) {
        this.airportFlightId = airportFlightId;
    }

    public Airport getFrom1() {
        return from1;
    }

    public void setFrom1(Airport from1) {
        this.from1 = from1;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airportFlightId != null ? airportFlightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AirportFlight)) {
            return false;
        }
        AirportFlight other = (AirportFlight) object;
        if ((this.airportFlightId == null && other.airportFlightId != null) || (this.airportFlightId != null && !this.airportFlightId.equals(other.airportFlightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.AirportFlight[ airportFlightId=" + airportFlightId + " ]";
    }

}

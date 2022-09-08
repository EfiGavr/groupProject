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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "airplane_flight")
@XmlRootElement
public class AirplaneFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "airplane_flight_id")
    private Integer airplaneFlightId;

    @JoinColumn(name = "airplane", referencedColumnName = "airplane_id")
    @ManyToOne
    @JsonBackReference
    private Airplane airplane;

    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    private Flight flight;

    public AirplaneFlight() {
    }

    public AirplaneFlight(Integer airplaneFlightId) {
        this.airplaneFlightId = airplaneFlightId;
    }

    public Integer getAirplaneFlightId() {
        return airplaneFlightId;
    }

    public void setAirplaneFlightId(Integer airplaneFlightId) {
        this.airplaneFlightId = airplaneFlightId;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
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
        hash += (airplaneFlightId != null ? airplaneFlightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AirplaneFlight)) {
            return false;
        }
        AirplaneFlight other = (AirplaneFlight) object;
        if ((this.airplaneFlightId == null && other.airplaneFlightId != null) || (this.airplaneFlightId != null && !this.airplaneFlightId.equals(other.airplaneFlightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.AirplaneFlight[ airplaneFlightId=" + airplaneFlightId + " ]";
    }

}

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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cabincrew_flight")
@XmlRootElement
public class CabincrewFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabincrew_flight_id")
    private Integer cabincrewFlightId;

    @JoinColumn(name = "cabincrew", referencedColumnName = "cabincrew_id")
    @ManyToOne
    private Cabincrew cabincrew;

    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    private Flight flight;

    public CabincrewFlight() {
    }

    public CabincrewFlight(Integer cabincrewFlightId) {
        this.cabincrewFlightId = cabincrewFlightId;
    }

    public Integer getCabincrewFlightId() {
        return cabincrewFlightId;
    }

    public void setCabincrewFlightId(Integer cabincrewFlightId) {
        this.cabincrewFlightId = cabincrewFlightId;
    }

    public Cabincrew getCabincrew() {
        return cabincrew;
    }

    public void setCabincrew(Cabincrew cabincrew) {
        this.cabincrew = cabincrew;
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
        hash += (cabincrewFlightId != null ? cabincrewFlightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabincrewFlight)) {
            return false;
        }
        CabincrewFlight other = (CabincrewFlight) object;
        if ((this.cabincrewFlightId == null && other.cabincrewFlightId != null) || (this.cabincrewFlightId != null && !this.cabincrewFlightId.equals(other.cabincrewFlightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.CabincrewFlight[ cabincrewFlightId=" + cabincrewFlightId + " ]";
    }

}

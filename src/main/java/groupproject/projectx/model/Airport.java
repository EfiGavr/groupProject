
package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
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

@Entity
@Table(name = "airport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a")})
public class Airport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "airport_id")
    private Integer airportId;
    
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    
    @Size(max = 45)
    @Column(name = "airportname")
    private String airportname;
    
    @OneToMany(mappedBy = "from1")
    @JsonManagedReference
    private Set<AirportFlight> airportFlightSet;
    
    @OneToMany(mappedBy = "to")
    @JsonManagedReference
    private Set<AirportFlight> airportFlightSet1;

    public Airport() {
    }

    public Airport(Integer airportId) {
        this.airportId = airportId;
    }

    public Integer getAirportId() {
        return airportId;
    }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirportname() {
        return airportname;
    }

    public void setAirportname(String airportname) {
        this.airportname = airportname;
    }

    @XmlTransient
    public Set<AirportFlight> getAirportFlightSet() {
        return airportFlightSet;
    }

    public void setAirportFlightSet(Set<AirportFlight> airportFlightSet) {
        this.airportFlightSet = airportFlightSet;
    }

    @XmlTransient
    public Set<AirportFlight> getAirportFlightSet1() {
        return airportFlightSet1;
    }

    public void setAirportFlightSet1(Set<AirportFlight> airportFlightSet1) {
        this.airportFlightSet1 = airportFlightSet1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airportId != null ? airportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airport)) {
            return false;
        }
        Airport other = (Airport) object;
        if ((this.airportId == null && other.airportId != null) || (this.airportId != null && !this.airportId.equals(other.airportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.Airport[ airportId=" + airportId + " ]";
    }
    
}

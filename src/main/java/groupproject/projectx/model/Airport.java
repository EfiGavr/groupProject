
package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
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


    public Airport(Integer airportId) {
        this.airportId = airportId;
    }


    @XmlTransient
    public Set<AirportFlight> getAirportFlightSet() {
        return airportFlightSet;
    }

    @XmlTransient
    public Set<AirportFlight> getAirportFlightSet1() {
        return airportFlightSet1;
    }

}

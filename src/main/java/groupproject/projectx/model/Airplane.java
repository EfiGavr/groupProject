
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "airplane")
@Getter
@Setter
@ToString(exclude = {"airplaneFlightSet"})
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Airplane implements Serializable {

    @Size(max = 45)
    @Column(name = "manufacture")
    private String manufacture;

    @Size(max = 45)
    @Column(name = "model_number")
    private String modelNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "airplane")
    private Set<AirplaneFlight> airplaneFlightSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "airplane_id")
    private Integer airplaneId;

    @Column(name = "capacity")
    private Integer capacity;


    public Airplane(Integer airplaneId) {
        this.airplaneId = airplaneId;
    }

    @XmlTransient
    public Set<AirplaneFlight> getAirplaneFlightSet() {
        return airplaneFlightSet;
    }

    public void setAirplaneFlightSet(Set<AirplaneFlight> airplaneFlightSet) {
        this.airplaneFlightSet = airplaneFlightSet;
    }

}


package groupproject.projectx.model;

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
@XmlRootElement
public class Airplane implements Serializable {

    @Size(max = 45)
    @Column(name = "manufacture")
    private String manufacture;
    
    @Size(max = 45)
    @Column(name = "model_number")
    private String modelNumber;
    
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
   

    public Airplane() {
    }

    public Airplane(Integer airplaneId) {
        this.airplaneId = airplaneId;
    }

    public Integer getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Integer airplaneId) {
        this.airplaneId = airplaneId;
    }


    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public Set<AirplaneFlight> getAirplaneFlightSet() {
        return airplaneFlightSet;
    }

    public void setAirplaneFlightSet(Set<AirplaneFlight> airplaneFlightSet) {
        this.airplaneFlightSet = airplaneFlightSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airplaneId != null ? airplaneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airplane)) {
            return false;
        }
        Airplane other = (Airplane) object;
        if ((this.airplaneId == null && other.airplaneId != null) || (this.airplaneId != null && !this.airplaneId.equals(other.airplaneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.Airplane[ airplaneId=" + airplaneId + " ]";
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    }

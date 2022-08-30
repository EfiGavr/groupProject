
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
@Table(name = "pilot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilot.findAll", query = "SELECT p FROM Pilot p")})
public class Pilot implements Serializable {

    @Size(max = 45)
    @Column(name = "fname")
    private String fname;
    
    @Size(max = 45)
    @Column(name = "lname")
    private String lname;
    
    @Size(max = 45)
    @Column(name = "contact_number")
    private String contactNumber;
    
    @OneToMany(mappedBy = "pilot")
    @JsonManagedReference
    private Set<PilotFlight> pilotFlightSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private Integer pilotId;
    
    @Column(name = "licence_number")
    private Integer licenceNumber;


    public Pilot() {
    }

    public Pilot(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public Integer getPilotId() {
        return pilotId;
    }

    public void setPilotId(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public Integer getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(Integer licenceNumber) {
        this.licenceNumber = licenceNumber;
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @XmlTransient
    public Set<PilotFlight> getPilotFlightSet() {
        return pilotFlightSet;
    }

    public void setPilotFlightSet(Set<PilotFlight> pilotFlightSet) {
        this.pilotFlightSet = pilotFlightSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pilotId != null ? pilotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        if ((this.pilotId == null && other.pilotId != null) || (this.pilotId != null && !this.pilotId.equals(other.pilotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.Pilot[ pilotId=" + pilotId + " ]";
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }  
}

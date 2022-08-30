package groupproject.projectx.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cabincrew")
@XmlRootElement
public class Cabincrew implements Serializable {

    @Size(max = 45)
    @Column(name = "cb_fname")
    private String cbFname;
    
    @Size(max = 45)
    @Column(name = "cb_lname")
    private String cbLname;
    
    @OneToMany(mappedBy = "cabincrew")
    private Set<CabincrewFlight> cabincrewFlightSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabincrew_id")
    private Integer cabincrewId;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cabincrew")
    private CabincrewNames cabincrewNames;

    public Cabincrew() {
    }

    public Cabincrew(Integer cabincrewId) {
        this.cabincrewId = cabincrewId;
    }

    public Integer getCabincrewId() {
        return cabincrewId;
    }

    public void setCabincrewId(Integer cabincrewId) {
        this.cabincrewId = cabincrewId;
    }

    public String getCbFname() {
        return cbFname;
    }

    public void setCbFname(String cbFname) {
        this.cbFname = cbFname;
    }

    public String getCbLname() {
        return cbLname;
    }

    public void setCbLname(String cbLname) {
        this.cbLname = cbLname;
    }

    public CabincrewNames getCabincrewNames() {
        return cabincrewNames;
    }

    public void setCabincrewNames(CabincrewNames cabincrewNames) {
        this.cabincrewNames = cabincrewNames;
    }

    @XmlTransient
    public Set<CabincrewFlight> getCabincrewFlightSet() {
        return cabincrewFlightSet;
    }

    public void setCabincrewFlightSet(Set<CabincrewFlight> cabincrewFlightSet) {
        this.cabincrewFlightSet = cabincrewFlightSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabincrewId != null ? cabincrewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabincrew)) {
            return false;
        }
        Cabincrew other = (Cabincrew) object;
        if ((this.cabincrewId == null && other.cabincrewId != null) || (this.cabincrewId != null && !this.cabincrewId.equals(other.cabincrewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.Cabincrew[ cabincrewId=" + cabincrewId + " ]";
    }
}

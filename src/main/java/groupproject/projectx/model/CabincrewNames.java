package groupproject.projectx.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cabincrew_names")
@XmlRootElement
public class CabincrewNames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cabincrew_names_id")
    private Integer cabincrewNamesId;

    @Size(max = 45)
    @Column(name = "cabincrew_fname")
    private String cabincrewFname;

    @Size(max = 45)
    @Column(name = "cabincrew_lname")
    private String cabincrewLname;

    @JoinColumn(name = "cabincrew_names_id", referencedColumnName = "cabincrew_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cabincrew cabincrew;

    public CabincrewNames() {
    }

    public CabincrewNames(Integer cabincrewNamesId) {
        this.cabincrewNamesId = cabincrewNamesId;
    }

    public Integer getCabincrewNamesId() {
        return cabincrewNamesId;
    }

    public void setCabincrewNamesId(Integer cabincrewNamesId) {
        this.cabincrewNamesId = cabincrewNamesId;
    }

    public String getCabincrewFname() {
        return cabincrewFname;
    }

    public void setCabincrewFname(String cabincrewFname) {
        this.cabincrewFname = cabincrewFname;
    }

    public String getCabincrewLname() {
        return cabincrewLname;
    }

    public void setCabincrewLname(String cabincrewLname) {
        this.cabincrewLname = cabincrewLname;
    }

    public Cabincrew getCabincrew() {
        return cabincrew;
    }

    public void setCabincrew(Cabincrew cabincrew) {
        this.cabincrew = cabincrew;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabincrewNamesId != null ? cabincrewNamesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabincrewNames)) {
            return false;
        }
        CabincrewNames other = (CabincrewNames) object;
        if ((this.cabincrewNamesId == null && other.cabincrewNamesId != null) || (this.cabincrewNamesId != null && !this.cabincrewNamesId.equals(other.cabincrewNamesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.CabincrewNames[ cabincrewNamesId=" + cabincrewNamesId + " ]";
    }

}

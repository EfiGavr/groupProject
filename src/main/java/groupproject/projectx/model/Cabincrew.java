package groupproject.projectx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Cabincrew implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabincrew_id")
    private Integer cabincrewId;

    @Size(max = 45)
    @Column(name = "cb_fname")
    private String cbFname;

    @Size(max = 45)
    @Column(name = "cb_lname")
    private String cbLname;

    @OneToMany(mappedBy = "cabincrew")
    private Set<CabincrewFlight> cabincrewFlightSet;

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cabincrew")
    private CabincrewNames cabincrewNames;

    public Cabincrew(Integer cabincrewId) {
        this.cabincrewId = cabincrewId;
    }

    @XmlTransient
    public Set<CabincrewFlight> getCabincrewFlightSet() {
        return cabincrewFlightSet;
    }

    public void setCabincrewFlightSet(Set<CabincrewFlight> cabincrewFlightSet) {
        this.cabincrewFlightSet = cabincrewFlightSet;
    }
}



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
@Table(name = "pilot")
@Getter
@Setter
@ToString(exclude = {"pilotFlightSet"})
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Pilot.findAll", query = "SELECT p FROM Pilot p")})
public class Pilot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private Integer pilotId;

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

    @Column(name = "licence_number")
    private Integer licenceNumber;

    public Pilot(Integer pilotId) {
        this.pilotId = pilotId;
    }

    @XmlTransient
    public Set<PilotFlight> getPilotFlightSet() {
        return pilotFlightSet;
    }

    public void setPilotFlightSet(Set<PilotFlight> pilotFlightSet) {
        this.pilotFlightSet = pilotFlightSet;
    }

}

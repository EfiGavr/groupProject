package groupproject.projectx.model;

import lombok.*;

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
@Getter
@Setter
@ToString(exclude = {"cabincrew"})
@AllArgsConstructor
@NoArgsConstructor
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

    public CabincrewNames(Integer cabincrewNamesId) {
        this.cabincrewNamesId = cabincrewNamesId;
    }

}

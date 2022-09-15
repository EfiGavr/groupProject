package groupproject.projectx.model;

import lombok.*;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cabincrew_flight")
@Getter
@Setter
@ToString(exclude = {"cabincrew","flight"})
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CabincrewFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabincrew_flight_id")
    private Integer cabincrewFlightId;

    @JoinColumn(name = "cabincrew", referencedColumnName = "cabincrew_id")
    @ManyToOne
    private Cabincrew cabincrew;

    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    private Flight flight;

    public CabincrewFlight(Integer cabincrewFlightId) {
        this.cabincrewFlightId = cabincrewFlightId;
    }
}

package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "airplane_flight")
@Getter
@Setter
@ToString(exclude = {"airplane","flight"})
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class AirplaneFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "airplane_flight_id")
    private Integer airplaneFlightId;

    @JoinColumn(name = "airplane", referencedColumnName = "airplane_id")
    @ManyToOne
    @JsonBackReference
    private Airplane airplane;

    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    private Flight flight;

    public AirplaneFlight(Integer airplaneFlightId) {
        this.airplaneFlightId = airplaneFlightId;
    }


}

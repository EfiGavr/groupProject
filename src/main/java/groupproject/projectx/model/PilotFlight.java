package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "pilot_flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement

public class PilotFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilot_flight_id")
    private Integer pilotFlightId;

    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    private Flight flight;

    @JoinColumn(name = "pilot", referencedColumnName = "pilot_id")
    @ManyToOne
    @JsonBackReference
    private Pilot pilot;

    public PilotFlight(Integer pilotFlightId) {
        this.pilotFlightId = pilotFlightId;
    }
}
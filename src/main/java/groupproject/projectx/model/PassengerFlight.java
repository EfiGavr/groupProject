/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "passenger_flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PassengerFlight.findAll", query = "SELECT p FROM PassengerFlight p"),
    @NamedQuery(name = "PassengerFlight.findByPassengerFlightId", query = "SELECT p FROM PassengerFlight p WHERE p.passengerFlightId = :passengerFlightId")})
public class PassengerFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "passenger_flight_id")
    private Integer passengerFlightId;
    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    private Flight flight;
    @JoinColumn(name = "passenger", referencedColumnName = "passenger_id")
    @ManyToOne
    private Passenger passenger;

    public PassengerFlight() {
    }

    public PassengerFlight(Integer passengerFlightId) {
        this.passengerFlightId = passengerFlightId;
    }

    public Integer getPassengerFlightId() {
        return passengerFlightId;
    }

    public void setPassengerFlightId(Integer passengerFlightId) {
        this.passengerFlightId = passengerFlightId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passengerFlightId != null ? passengerFlightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PassengerFlight)) {
            return false;
        }
        PassengerFlight other = (PassengerFlight) object;
        if ((this.passengerFlightId == null && other.passengerFlightId != null) || (this.passengerFlightId != null && !this.passengerFlightId.equals(other.passengerFlightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PassengerFlight{passengerFlightId=").append(passengerFlightId);
        sb.append(", flight=").append(flight);
        sb.append(", passenger=").append(passenger);
        sb.append('}');
        return sb.toString();
    }

  
    
}

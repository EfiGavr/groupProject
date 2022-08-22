/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
    @NamedQuery(name = "Flight.findByFlightId", query = "SELECT f FROM Flight f WHERE f.flightId = :flightId"),
    @NamedQuery(name = "Flight.findByDeparture", query = "SELECT f FROM Flight f WHERE f.departure = :departure"),
    @NamedQuery(name = "Flight.findByArrival", query = "SELECT f FROM Flight f WHERE f.arrival = :arrival")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "flight_id")
    private Integer flightId;
    @Column(name = "departure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departure;
    @Column(name = "arrival")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrival;
    @OneToMany(mappedBy = "flight")
    private Set<PilotFlight> pilotFlightSet;
    @JoinColumn(name = "to", referencedColumnName = "route_id")
    @ManyToOne
    private Route to;
    @JoinColumn(name = "from", referencedColumnName = "route_id")
    @ManyToOne
    private Route from1;
    @OneToMany(mappedBy = "flight")
    private Set<PassengerFlight> passengerFlightSet;
    @OneToMany(mappedBy = "flight")
    private Set<AirplaneFlight> airplaneFlightSet;
    @OneToMany(mappedBy = "flight")
    private Set<RouteFlight> routeFlightSet;

    public Flight() {
    }

    public Flight(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    @XmlTransient
    public Set<PilotFlight> getPilotFlightSet() {
        return pilotFlightSet;
    }

    public void setPilotFlightSet(Set<PilotFlight> pilotFlightSet) {
        this.pilotFlightSet = pilotFlightSet;
    }

    public Route getTo() {
        return to;
    }

    public void setTo(Route to) {
        this.to = to;
    }

    public Route getFrom1() {
        return from1;
    }

    public void setFrom1(Route from1) {
        this.from1 = from1;
    }

    @XmlTransient
    public Set<PassengerFlight> getPassengerFlightSet() {
        return passengerFlightSet;
    }

    public void setPassengerFlightSet(Set<PassengerFlight> passengerFlightSet) {
        this.passengerFlightSet = passengerFlightSet;
    }

    @XmlTransient
    public Set<AirplaneFlight> getAirplaneFlightSet() {
        return airplaneFlightSet;
    }

    public void setAirplaneFlightSet(Set<AirplaneFlight> airplaneFlightSet) {
        this.airplaneFlightSet = airplaneFlightSet;
    }

    @XmlTransient
    public Set<RouteFlight> getRouteFlightSet() {
        return routeFlightSet;
    }

    public void setRouteFlightSet(Set<RouteFlight> routeFlightSet) {
        this.routeFlightSet = routeFlightSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightId != null ? flightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.flightId == null && other.flightId != null) || (this.flightId != null && !this.flightId.equals(other.flightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flight{flightId=").append(flightId);
        sb.append(", departure=").append(departure);
        sb.append(", arrival=").append(arrival);
        sb.append(", pilotFlightSet=").append(pilotFlightSet);
        sb.append(", to=").append(to);
        sb.append(", from1=").append(from1);
        sb.append(", passengerFlightSet=").append(passengerFlightSet);
        sb.append(", airplaneFlightSet=").append(airplaneFlightSet);
        sb.append(", routeFlightSet=").append(routeFlightSet);
        sb.append('}');
        return sb.toString();
    }

   
}

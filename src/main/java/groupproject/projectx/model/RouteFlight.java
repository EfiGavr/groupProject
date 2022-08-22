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
@Table(name = "route_flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteFlight.findAll", query = "SELECT r FROM RouteFlight r"),
    @NamedQuery(name = "RouteFlight.findByRouteFlightId", query = "SELECT r FROM RouteFlight r WHERE r.routeFlightId = :routeFlightId")})
public class RouteFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "route_flight_id")
    private Integer routeFlightId;
    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    private Flight flight;
    @JoinColumn(name = "route", referencedColumnName = "route_id")
    @ManyToOne
    private Route route;

    public RouteFlight() {
    }

    public RouteFlight(Integer routeFlightId) {
        this.routeFlightId = routeFlightId;
    }

    public Integer getRouteFlightId() {
        return routeFlightId;
    }

    public void setRouteFlightId(Integer routeFlightId) {
        this.routeFlightId = routeFlightId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeFlightId != null ? routeFlightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RouteFlight)) {
            return false;
        }
        RouteFlight other = (RouteFlight) object;
        if ((this.routeFlightId == null && other.routeFlightId != null) || (this.routeFlightId != null && !this.routeFlightId.equals(other.routeFlightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RouteFlight{routeFlightId=").append(routeFlightId);
        sb.append(", flight=").append(flight);
        sb.append(", route=").append(route);
        sb.append('}');
        return sb.toString();
    }

  
    
}

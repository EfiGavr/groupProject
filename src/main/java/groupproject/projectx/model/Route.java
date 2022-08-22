/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

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

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findByRouteId", query = "SELECT r FROM Route r WHERE r.routeId = :routeId"),
    @NamedQuery(name = "Route.findByCountry", query = "SELECT r FROM Route r WHERE r.country = :country"),
    @NamedQuery(name = "Route.findByCity", query = "SELECT r FROM Route r WHERE r.city = :city"),
    @NamedQuery(name = "Route.findByAirport", query = "SELECT r FROM Route r WHERE r.airport = :airport")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "route_id")
    private Integer routeId;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "airport")
    private String airport;
    @OneToMany(mappedBy = "to")
    private Set<Flight> flightSet;
    @OneToMany(mappedBy = "from1")
    private Set<Flight> flightSet1;
    @OneToMany(mappedBy = "route")
    private Set<RouteFlight> routeFlightSet;

    public Route() {
    }

    public Route(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    @XmlTransient
    public Set<Flight> getFlightSet() {
        return flightSet;
    }

    public void setFlightSet(Set<Flight> flightSet) {
        this.flightSet = flightSet;
    }

    @XmlTransient
    public Set<Flight> getFlightSet1() {
        return flightSet1;
    }

    public void setFlightSet1(Set<Flight> flightSet1) {
        this.flightSet1 = flightSet1;
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
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route{routeId=").append(routeId);
        sb.append(", country=").append(country);
        sb.append(", city=").append(city);
        sb.append(", airport=").append(airport);
        sb.append(", flightSet=").append(flightSet);
        sb.append(", flightSet1=").append(flightSet1);
        sb.append(", routeFlightSet=").append(routeFlightSet);
        sb.append('}');
        return sb.toString();
    }

   
    
}

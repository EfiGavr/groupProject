/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "passenger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
    @NamedQuery(name = "Passenger.findByPassengerId", query = "SELECT p FROM Passenger p WHERE p.passengerId = :passengerId"),
    @NamedQuery(name = "Passenger.findByTelephoneNumber", query = "SELECT p FROM Passenger p WHERE p.telephoneNumber = :telephoneNumber"),
    @NamedQuery(name = "Passenger.findByEmail", query = "SELECT p FROM Passenger p WHERE p.email = :email"),
    @NamedQuery(name = "Passenger.findByFname", query = "SELECT p FROM Passenger p WHERE p.fname = :fname"),
    @NamedQuery(name = "Passenger.findByLname", query = "SELECT p FROM Passenger p WHERE p.lname = :lname")})
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "passenger_id")
    private Integer passengerId;
    @Size(max = 45)
    @Column(name = "telephone_number")
    private String telephoneNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "fname")
    private String fname;
    @Size(max = 45)
    @Column(name = "lname")
    private String lname;
    @OneToMany(mappedBy = "passenger")
    private Set<PassengerFlight> passengerFlightSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "passenger")
    private Member member;
    @OneToMany(mappedBy = "passenger")
    private Set<Passengertoticket> passengertoticketSet;

    public Passenger() {
    }

    public Passenger(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @XmlTransient
    public Set<PassengerFlight> getPassengerFlightSet() {
        return passengerFlightSet;
    }

    public void setPassengerFlightSet(Set<PassengerFlight> passengerFlightSet) {
        this.passengerFlightSet = passengerFlightSet;
    }

    public Member getMember1() {
        return member;
    }

    public void setMember1(Member member) {
        this.member = member;
    }

    @XmlTransient
    public Set<Passengertoticket> getPassengertoticketSet() {
        return passengertoticketSet;
    }

    public void setPassengertoticketSet(Set<Passengertoticket> passengertoticketSet) {
        this.passengertoticketSet = passengertoticketSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passengerId != null ? passengerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.passengerId == null && other.passengerId != null) || (this.passengerId != null && !this.passengerId.equals(other.passengerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passenger{passengerId=").append(passengerId);
        sb.append(", telephoneNumber=").append(telephoneNumber);
        sb.append(", email=").append(email);
        sb.append(", fname=").append(fname);
        sb.append(", lname=").append(lname);
        sb.append(", passengerFlightSet=").append(passengerFlightSet);
        sb.append(", member=").append(member);
        sb.append(", passengertoticketSet=").append(passengertoticketSet);
        sb.append('}');
        return sb.toString();
    }

   
    
}

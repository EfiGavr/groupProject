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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "passenger")
@XmlRootElement

public class Passenger implements Serializable {

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
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "passenger_id")
    private Integer passengerId;
    
    @OneToMany(mappedBy = "passenger")
    private Set<PassengerTicket> passengerTicketSet;
    
    @OneToMany(mappedBy = "passenger")
    private Set<PassengerFlight> passengerFlightSet;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "passenger")
    private Members member1;

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


    @XmlTransient
    public Set<PassengerTicket> getPassengerTicketSet() {
        return passengerTicketSet;
    }

    public void setPassengerTicketSet(Set<PassengerTicket> passengerTicketSet) {
        this.passengerTicketSet = passengerTicketSet;
    }



    public void setPassengerFlightSet(Set<PassengerFlight> passengerFlightSet) {
        this.passengerFlightSet = passengerFlightSet;
    }

    public Members getMember1() {
        return member1;
    }

    public void setMember1(Members member1) {
        this.member1 = member1;
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
        return "groupproject.projectx.model.Passenger[ passengerId=" + passengerId + " ]";
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
}

package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;

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

    @Size(max = 45)
    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private Set<ClientFlight> clientFlightSet;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
    private Members members;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private Set<ClientTicket> clientTicketSet;

    public Client() {
    }

    public Client(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Set<ClientFlight> getClientFlightSet() {
        return clientFlightSet;
    }

    public void setClientFlightSet(Set<ClientFlight> clientFlightSet) {
        this.clientFlightSet = clientFlightSet;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    @XmlTransient
    public Set<ClientTicket> getClientTicketSet() {
        return clientTicketSet;
    }

    public void setClientTicketSet(Set<ClientTicket> clientTicketSet) {
        this.clientTicketSet = clientTicketSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.Client[ clientId=" + clientId + " ]";
    }

}

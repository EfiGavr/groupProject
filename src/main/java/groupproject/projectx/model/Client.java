package groupproject.projectx.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

@Entity
@Table(name = "client")
@Getter
@Setter
@ToString(exclude = {"clientTicketSet"})
@AllArgsConstructor
@NoArgsConstructor
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

    @Size(max = 45)
    @Column(name = "username")
    private String username;

    @Size(max = 45)
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "client",orphanRemoval = true)
//    , orphanRemoval = true
    @JsonManagedReference
    private Set<ClientTicket> clientTicketSet;

    public Client(Integer clientId) {
        this.clientId = clientId;
    }


    @XmlTransient
    public Set<ClientTicket> getClientTicketSet() {
        return clientTicketSet;
    }

    public void setClientTicketSet(Set<ClientTicket> clientTicketSet) {
        this.clientTicketSet = clientTicketSet;
    }

}

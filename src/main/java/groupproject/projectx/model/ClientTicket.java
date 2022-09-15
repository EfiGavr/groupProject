
package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "client_ticket")
@Getter
@Setter
@ToString(exclude = {"client", "ticket"})
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ClientTicket.findAll", query = "SELECT c FROM ClientTicket c")})
public class ClientTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_ticket_id")
    private Integer clientTicketId;

    @JoinColumn(name = "client", referencedColumnName = "client_id")
    @ManyToOne
    @JsonBackReference
//    @JsonIgnoreProperties
    private Client client;

    @JoinColumn(name = "ticket", referencedColumnName = "ticket_id")
    @ManyToOne
    @JsonBackReference
    private Ticket ticket;

    public ClientTicket(Integer clientTicketId) {
        this.clientTicketId = clientTicketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientTicket that = (ClientTicket) o;
        return clientTicketId != null && Objects.equals(clientTicketId, that.clientTicketId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

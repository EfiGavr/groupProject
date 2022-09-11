
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "client_ticket")
@Data
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
    private Client client;

    @JoinColumn(name = "ticket", referencedColumnName = "ticket_id")
    @ManyToOne
    @JsonBackReference
    private Ticket ticket;

    public ClientTicket(Integer clientTicketId) {
        this.clientTicketId = clientTicketId;
    }

}


package groupproject.projectx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    public ClientTicket() {
    }

    public ClientTicket(Integer clientTicketId) {
        this.clientTicketId = clientTicketId;
    }

    public Integer getClientTicketId() {
        return clientTicketId;
    }

    public void setClientTicketId(Integer clientTicketId) {
        this.clientTicketId = clientTicketId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientTicketId != null ? clientTicketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientTicket)) {
            return false;
        }
        ClientTicket other = (ClientTicket) object;
        if ((this.clientTicketId == null && other.clientTicketId != null) || (this.clientTicketId != null && !this.clientTicketId.equals(other.clientTicketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.ClientTicket[ clientTicketId=" + clientTicketId + " ]";
    }

}

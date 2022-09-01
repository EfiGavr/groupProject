
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
@Table(name = "client_flight")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ClientFlight.findAll", query = "SELECT c FROM ClientFlight c")})
public class ClientFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_flight_id")
    private Integer clientFlightId;

    @JoinColumn(name = "client", referencedColumnName = "client_id")
    @ManyToOne
    @JsonBackReference
    private Client client;

    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    @JsonBackReference
    private Flight flight;

    public ClientFlight() {
    }

    public ClientFlight(Integer clientFlightId) {
        this.clientFlightId = clientFlightId;
    }

    public Integer getClientFlightId() {
        return clientFlightId;
    }

    public void setClientFlightId(Integer clientFlightId) {
        this.clientFlightId = clientFlightId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientFlightId != null ? clientFlightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientFlight)) {
            return false;
        }
        ClientFlight other = (ClientFlight) object;
        if ((this.clientFlightId == null && other.clientFlightId != null) || (this.clientFlightId != null && !this.clientFlightId.equals(other.clientFlightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.ClientFlight[ clientFlightId=" + clientFlightId + " ]";
    }

}

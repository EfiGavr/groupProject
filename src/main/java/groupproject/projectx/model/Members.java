
package groupproject.projectx.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "member")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m")})
public class Members implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_id")
    private Integer memberId;

    @Size(max = 45)
    @Column(name = "username")
    private String username;

    @Size(max = 60)
    @Column(name = "password")
    private String password;

    @Column(name = "bonus")
    private Integer bonus;

    @JoinColumn(name = "member_id", referencedColumnName = "client_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Client client;

    public Members() {
    }

    public Members(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupproject.projectx.model.Members[ memberId=" + memberId + " ]";
    }

}

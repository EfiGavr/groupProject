
package groupproject.projectx.model;

import lombok.*;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m")})
public class Member implements Serializable {

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

    public Member(Integer memberId) {
        this.memberId = memberId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}

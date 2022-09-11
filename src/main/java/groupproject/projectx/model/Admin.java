package groupproject.projectx.model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
    private Integer adminId;

    @Size(max = 45)
    @Column(name = "ad_username")
    private String adUsername;

    @Size(max = 45)
    @Column(name = "ad_password")
    private String adPassword;

    public Admin(Integer adminId) {
        this.adminId = adminId;
    }

}

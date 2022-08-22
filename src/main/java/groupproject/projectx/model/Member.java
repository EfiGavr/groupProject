/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m"),
    @NamedQuery(name = "Member1.findByMemberId", query = "SELECT m FROM Member1 m WHERE m.memberId = :memberId"),
    @NamedQuery(name = "Member1.findByBonus", query = "SELECT m FROM Member1 m WHERE m.bonus = :bonus"),
    @NamedQuery(name = "Member1.findBySinceWhen", query = "SELECT m FROM Member1 m WHERE m.sinceWhen = :sinceWhen")})
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "bonus")
    private Integer bonus;
    @Column(name = "since_when")
    @Temporal(TemporalType.DATE)
    private Date sinceWhen;
    @JoinColumn(name = "member_id", referencedColumnName = "passenger_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Passenger passenger;

    public Member() {
    }

    public Member(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Date getSinceWhen() {
        return sinceWhen;
    }

    public void setSinceWhen(Date sinceWhen) {
        this.sinceWhen = sinceWhen;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
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
        if (!(object instanceof Member)) {
            return false;
        }
        Member other = (Member) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Member1{memberId=").append(memberId);
        sb.append(", bonus=").append(bonus);
        sb.append(", sinceWhen=").append(sinceWhen);
        sb.append(", passenger=").append(passenger);
        sb.append('}');
        return sb.toString();
    }

   
    
}

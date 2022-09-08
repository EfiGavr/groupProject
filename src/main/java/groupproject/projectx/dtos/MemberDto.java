package groupproject.projectx.dtos;

public class MemberDto {
    
    private Integer memberId;
    private String username;
    private String password;
    private Integer bonus;

    public MemberDto(String username, String password, Integer bonus) {
        this.username = username;
        this.password = password;
        this.bonus = bonus;
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
    
}

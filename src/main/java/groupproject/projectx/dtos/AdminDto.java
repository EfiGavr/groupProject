package groupproject.projectx.dtos;

public class AdminDto {

    private String adUsername;

    private String adPassword;

    public AdminDto() {
    }

    public String getAdUsername() {
        return adUsername;
    }

    public void setAdUsername(String adUsername) {
        this.adUsername = adUsername;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "adUsername='" + adUsername + '\'' +
                ", adPassword='" + adPassword + '\'' +
                '}';
    }
}

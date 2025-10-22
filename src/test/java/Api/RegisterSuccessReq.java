package Api;

public class RegisterSuccessReq {
    private String email;
    private String password;

    public RegisterSuccessReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

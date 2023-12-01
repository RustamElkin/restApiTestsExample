package api.models.auth_service.login_successful;

public class LoginSuccessfulResponse {
    private String token;

    public LoginSuccessfulResponse() {}

    public LoginSuccessfulResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}


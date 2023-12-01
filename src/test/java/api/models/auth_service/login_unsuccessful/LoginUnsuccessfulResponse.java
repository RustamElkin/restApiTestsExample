package api.models.auth_service.login_unsuccessful;

public class LoginUnsuccessfulResponse {
    private String error;

    public LoginUnsuccessfulResponse() {
    }

    public LoginUnsuccessfulResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}


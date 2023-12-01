package api.models.auth_service.register_unsuccessful;

public class RegisterUnsuccessfulResponse {
    private String error;

    public RegisterUnsuccessfulResponse() {}

    public RegisterUnsuccessfulResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}



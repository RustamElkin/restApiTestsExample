package api.models.auth_service.register_successful;

public class RegisterSuccessfulResponse {
    private Long id;
    private String token;

    public RegisterSuccessfulResponse() {}
    public RegisterSuccessfulResponse(Long id, String token) {
        this.id = id;
        this.token = token;
    }

    public Long getId() {
        return this.id;
    }

    public String getToken() {
        return this.token;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }
}


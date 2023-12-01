package api.controllers.authservice;

import api.TestBase;
import api.endpoints.Routes;
import api.models.auth_service.login_successful.LoginSuccessfulResponse;
import api.models.auth_service.login_unsuccessful.LoginUnsuccessfulResponse;
import api.models.auth_service.register_successful.RegisterSuccessfulResponse;
import api.models.auth_service.register_unsuccessful.RegisterUnsuccessfulResponse;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

import static api.endpoints.Routes.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthServiceController extends TestBase {

    public static void postRegisterSuccessful() throws IOException {
        String url = Routes.BASE_URL + REGISTER_SUCCESSFUL;
        RequestBody requestBody = new FormBody.Builder()
                .add("email", "eve.holt@reqres.in")
                .add("password", "pistol")
                .build();
        Response response = postRequest(url, requestBody);

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        String jsonResponse = response.body().string();
        RegisterSuccessfulResponse registerSuccessfulResponse = objectMapper.readValue(jsonResponse, RegisterSuccessfulResponse.class);

        assertThat(response.code()).isEqualTo(200);
        assertThat(registerSuccessfulResponse.getId()).isEqualTo(4);
        assertThat(registerSuccessfulResponse.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
    public static void postRegisterUnsuccessful() throws IOException {
        String url = Routes.BASE_URL + REGISTER_UNSUCCESSFUL;
        RequestBody requestBody = new FormBody.Builder()
                .add("email", "sydney@fife")
                .build();
        Response response = postRequest(url, requestBody);
        String jsonResponse = response.body().string();
        RegisterUnsuccessfulResponse registerUnsuccessfulResponse = objectMapper.readValue(jsonResponse, RegisterUnsuccessfulResponse.class);

        assertThat(response.code()).isEqualTo(400);
        assertThat(registerUnsuccessfulResponse.getError()).isEqualTo("Missing password");
    }
    public static void postLoginSuccessful() throws IOException {
        String url = Routes.BASE_URL + LOGIN_SUCCESSFUL;
        RequestBody requestBody = new FormBody.Builder()
                .add("email", "eve.holt@reqres.in")
                .add("password", "cityslicka")
                .build();
        Response response = postRequest(url, requestBody);

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        String jsonResponse = response.body().string();
        LoginSuccessfulResponse loginSuccessfulResponse = objectMapper.readValue(jsonResponse, LoginSuccessfulResponse.class);

        assertThat(response.code()).isEqualTo(200);
        assertThat(loginSuccessfulResponse.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    public static void postLoginUnsuccessful() throws IOException {
        String url = Routes.BASE_URL + LOGIN_UNSUCCESSFUL;
        RequestBody requestBody = new FormBody.Builder()
                .add("email", "peter@klaven")
                .build();

        Response response = postRequest(url, requestBody);
        assert response.body() != null;
        String jsonResponse = response.body().string();
        LoginUnsuccessfulResponse loginUnsuccessfulResponse = objectMapper.readValue(jsonResponse, LoginUnsuccessfulResponse.class);

        assertThat(response.code()).isEqualTo(400);
        assertThat(loginUnsuccessfulResponse.getError()).isEqualTo("Missing password");
    }
}

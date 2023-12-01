package api.controllers.userservice;


import api.TestBase;
import api.endpoints.Routes;
import api.models.user_service.delay.DelayedResponse;
import api.models.user_service.list_users.ListUsersResponse;
import api.models.user_service.single_user.SingleUserResponse;
import api.models.user_service.users.UsersResponse;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

import static api.endpoints.Routes.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceControllers extends TestBase {

    public static void getListOfUsers(int page_id) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + Routes.LIST_USERS)).newBuilder();
        urlBuilder.addQueryParameter("page", String.valueOf(page_id));
        String url = urlBuilder.build().toString();

        Response response = getRequest(url);
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            // Получение JSON-строки из ответа
            String jsonResponse = response.body().string();
            // Преобразование JSON в объект User с помощью Jackson
            ListUsersResponse listUsersResponse = objectMapper.readValue(jsonResponse, ListUsersResponse.class);

        assertThat(response.code()).isEqualTo(200);
        assertThat(listUsersResponse.getPerPage()).isEqualTo(6);
        assertThat(listUsersResponse.getTotal()).isEqualTo(12);
        assertThat(listUsersResponse.getData().get(0).getEmail()).isEqualTo("michael.lawson@reqres.in");

    }
    public static void getSingleUser(int userId) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + SINGLE_USER)).newBuilder();
        urlBuilder.setPathSegment(2, String.valueOf(userId));
        String url = urlBuilder.build().toString();

        Response response = getRequest(url);
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        // Получение JSON-строки из ответа
        String jsonResponse = response.body().string();
        // Преобразование JSON в объект User с помощью Jackson
        SingleUserResponse singleUserResponse = objectMapper.readValue(jsonResponse, SingleUserResponse.class);

        assertThat(response.code()).isEqualTo(200);
        assertThat(singleUserResponse.getData().getEmail()).isEqualTo("janet.weaver@reqres.in");
    }
    public static void getSingleUserNotFound(int userId) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + SINGLE_USER_NOT_FOUND)).newBuilder();
        urlBuilder.setPathSegment(2, String.valueOf(userId));
        String url = urlBuilder.build().toString();
        Response response = getRequest(url);

        assertThat(response.code()).isEqualTo(404);
        assertThat(response.body().string()).isEqualTo("{}");
    }
    public static void postCreateUser() throws IOException {
        String url = Routes.BASE_URL + Routes.CREATE_USER;
        RequestBody requestBody = new FormBody.Builder()
                .add("name", "morpheus")
                .add("job", "leader")
                .build();
        Response response = postRequest(url, requestBody);

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        String jsonResponse = response.body().string();
        UsersResponse usersResponse = objectMapper.readValue(jsonResponse, UsersResponse.class);

        assertThat(response.code()).isEqualTo(201);
        assertThat(usersResponse.getName()).isEqualTo("morpheus");
        assertThat(usersResponse.getJob()).isEqualTo("leader");
    }
    public static void putChangeUser(int userId) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + UPDATE_USER)).newBuilder();
        urlBuilder.setPathSegment(2, String.valueOf(userId));
        String url = urlBuilder.build().toString();
        RequestBody requestBody = new FormBody.Builder()
                .add("name", "morpheus")
                .add("job", "zion resident")
                .build();
        Response response = putRequest(url, requestBody);

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        String jsonResponse = response.body().string();
        UsersResponse usersResponse = objectMapper.readValue(jsonResponse, UsersResponse.class);

        assertThat(response.code()).isEqualTo(200);
        assertThat(usersResponse.getName()).isEqualTo("morpheus");
        assertThat(usersResponse.getJob()).isEqualTo("zion resident");
    }
    public static void patchChangeUser(int userId) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + UPDATE_USER_PATCH)).newBuilder();
        urlBuilder.setPathSegment(2, String.valueOf(userId));
        String url = urlBuilder.build().toString();
        RequestBody requestBody = new FormBody.Builder()
                .add("name", "morpheus")
                .add("job", "zion resident")
                .build();
        Response response = patchRequest(url, requestBody);

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        String jsonResponse = response.body().string();
        UsersResponse usersResponse = objectMapper.readValue(jsonResponse, UsersResponse.class);

        assertThat(response.code()).isEqualTo(200);
        assertThat(usersResponse.getName()).isEqualTo("morpheus");
        assertThat(usersResponse.getJob()).isEqualTo("zion resident");
    }
    public static void deleteUser(int userId) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + DELETE_USER)).newBuilder();
        urlBuilder.setPathSegment(2, String.valueOf(userId));
        String url = urlBuilder.build().toString();
        Response response = deleteRequest(url);
        assertThat(response.code()).isEqualTo(204);
        assertThat(response.body().string()).isEqualTo("");
    }
    public static void getDelayedResponse(int delayId) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + DELAYED_RESPONSE)).newBuilder();
        urlBuilder.addQueryParameter("delay", String.valueOf(delayId));
        String url = urlBuilder.build().toString();
        Response response = getRequest(url);

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        String jsonResponse = response.body().string();
        DelayedResponse delayedResponse = objectMapper.readValue(jsonResponse, DelayedResponse.class);

        System.out.println(delayedResponse.getData().get(0).getEmail());

        assertThat(response.code()).isEqualTo(200);
    }
}

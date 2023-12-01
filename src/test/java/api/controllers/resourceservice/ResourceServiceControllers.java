package api.controllers.resourceservice;


import api.TestBase;
import api.endpoints.Routes;
import api.models.resource_service.list_resource.ListResourceResponse;
import api.models.resource_service.single_resource.SingleResourceResponse;
import okhttp3.HttpUrl;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

import static api.endpoints.Routes.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ResourceServiceControllers extends TestBase {

    public static void getListResource() throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + LIST_RESOURCE)).newBuilder();

        String url = urlBuilder.build().toString();

        Response response = getRequest(url);
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        // Получение JSON-строки из ответа
        assert response.body() != null;
        String jsonResponse = response.body().string();
        // Преобразование JSON в объект User с помощью Jackson
        ListResourceResponse listResourceResponse = objectMapper.readValue(jsonResponse, ListResourceResponse.class);

        assertThat(response.code()).isEqualTo(200);
        assertThat(listResourceResponse.getData().get(5).getName()).isEqualTo("blue turquoise");


    }
    public static void getSingleResource(int resource_id) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + SINGLE_RESOURCE)).newBuilder();
        urlBuilder.setPathSegment(2, String.valueOf(resource_id));
        String url = urlBuilder.build().toString();

        Response response = getRequest(url);
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        String jsonResponse = response.body().string();
        SingleResourceResponse singleResourceResponse = objectMapper.readValue(jsonResponse, SingleResourceResponse.class);

        assertThat(response.code()).isEqualTo(200);
        assertThat(singleResourceResponse.getData().getId()).isEqualTo(2);
        assertThat(singleResourceResponse.getData().getName()).isEqualTo("fuchsia rose");
    }

    public static void getSingleResourceNotFound(int resource_id) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
                HttpUrl.parse(Routes.BASE_URL + SINGLE_RESOURCE_NOT_FOUND)).newBuilder();
        urlBuilder.setPathSegment(2, String.valueOf(resource_id));
        String url = urlBuilder.build().toString();
        Response response = getRequest(url);

        assertThat(response.code()).isEqualTo(404);
        assert response.body() != null;
        assertThat(response.body().string()).isEqualTo("{}");
    }
}

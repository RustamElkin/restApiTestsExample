package api;

import api.okhttp_client.OkHttpSingleton;
import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class TestBase {
    private static final OkHttpClient client = OkHttpSingleton.getInstance().getClient();
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map bodyToMap(Response response) throws JsonProcessingException {
        String json;
        try {
            json = response.body().string();
        } catch (IOException e) {
            json = "{}";
        }

        return objectMapper.readValue(json, Map.class);
    }

    public static Response getRequest(String url) {
        try {
            final Request request = new Request.Builder().url(url).get().build();

            final Call call = client.newCall(request);

            return call.execute();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during GET request.", e);
        }
    }

    public static Response postRequest(String url, RequestBody requestBody) {
        try {
            final Request request = new Request.Builder().url(url).post(requestBody).build();

            final Call call = client.newCall(request);

            return call.execute();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during POST request.", e);
        }
    }

    public static Response putRequest(String url, RequestBody requestBody) {
        try {
            final Request request = new Request.Builder().url(url).put(requestBody).build();

            final Call call = client.newCall(request);

            return call.execute();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during PUT request.", e);
        }
    }

    public static Response patchRequest(String url, RequestBody requestBody) {
        try {
            final Request request = new Request.Builder().url(url).patch(requestBody).build();

            final Call call = client.newCall(request);

            return call.execute();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during PATCH request.", e);
        }
    }

    public static Response deleteRequest(String url) {
        try {
            final Request request = new Request.Builder().url(url).delete().build();

            final Call call = client.newCall(request);

            return call.execute();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during DELETE request.", e);
        }
    }
}


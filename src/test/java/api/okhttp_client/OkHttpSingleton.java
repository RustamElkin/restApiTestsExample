package api.okhttp_client;

import api.logging.SimpleLogEventsListener;
import okhttp3.OkHttpClient;

public class OkHttpSingleton {

    private static OkHttpSingleton singletonInstance;

    // No need to be static; OkHttpSingleton is unique so is this.
    private OkHttpClient client;

    // Private so that this cannot be instantiated.
    private OkHttpSingleton() {
        client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .eventListener(new SimpleLogEventsListener())
                .build();
    }

    public static OkHttpSingleton getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new OkHttpSingleton();
        }
        return singletonInstance;
    }

    // In case you just need the unique OkHttpClient instance.
    public OkHttpClient getClient() {
        return client;
    }

    public void closeConnections() {
        client.dispatcher().cancelAll();
    }
}
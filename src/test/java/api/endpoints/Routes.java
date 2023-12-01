package api.endpoints;

public class Routes {
    public static final String BASE_URL = "https://reqres.in/api/";

    public static final String LIST_USERS = "users"; // "users?page={page_id}"
    public static final String SINGLE_USER = "users/{user_id}";
    public static final String SINGLE_USER_NOT_FOUND = "users/{user_id}";
    public static final String LIST_RESOURCE = "unknown";
    public static final String SINGLE_RESOURCE = "unknown/{resource_id}";
    public static final String SINGLE_RESOURCE_NOT_FOUND = "unknown/{resource_id}";
    public static final String CREATE_USER = "users";
    public static final String UPDATE_USER = "users/{user_id}";
    public static final String UPDATE_USER_PATCH = "users/{user_id}";
    public static final String DELETE_USER = "users/{user_id}";
    public static final String REGISTER_SUCCESSFUL = "register";
    public static final String REGISTER_UNSUCCESSFUL = "register";
    public static final String LOGIN_SUCCESSFUL = "login";
    public static final String LOGIN_UNSUCCESSFUL = "login";
    public static final String DELAYED_RESPONSE = "users"; //users?delay={delayId}
}

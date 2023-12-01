package api.tests;

import api.controllers.authservice.AuthServiceController;
import api.controllers.resourceservice.ResourceServiceControllers;
import api.controllers.userservice.UserServiceControllers;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ReqresInApiTests {

    @Test
    void getListOfUsersTest() throws IOException { UserServiceControllers.getListOfUsers(2); }

    @Test
    void getSingleUserTest() throws IOException { UserServiceControllers.getSingleUser(2); }

    @Test
    void getSingleUserNotFoundTest() throws IOException { UserServiceControllers.getSingleUserNotFound(23); }

    @Test
    void getListResourceTest() throws IOException { ResourceServiceControllers.getListResource(); }

    @Test
    void getSingleResourceTest() throws IOException { ResourceServiceControllers.getSingleResource(2); }

    @Test
    void getSingleResourceNotFoundTest() throws IOException { ResourceServiceControllers.getSingleResourceNotFound(23); }

    @Test
    void postCreateUserTest() throws IOException { UserServiceControllers.postCreateUser(); }

    @Test
    void putChangeUserTest() throws IOException { UserServiceControllers.putChangeUser(2); }

    @Test
    void patchChangeUserTest() throws IOException { UserServiceControllers.patchChangeUser(2); }

    @Test
    void deleteUserTest() throws IOException { UserServiceControllers.deleteUser(2); }

    @Test
    void postRegisterSuccessfulTest() throws IOException { AuthServiceController.postRegisterSuccessful(); }

    @Test
    void postRegisterUnsuccessfulTest() throws IOException { AuthServiceController.postRegisterUnsuccessful(); }

    @Test
    void postLoginSuccessful() throws IOException { AuthServiceController.postLoginSuccessful(); }

    @Test
    void postLoginUnsuccessfulTest() throws IOException { AuthServiceController.postLoginUnsuccessful(); }

    @Test
    void getDelayedResponseTest() throws IOException { UserServiceControllers.getDelayedResponse(3);}
}

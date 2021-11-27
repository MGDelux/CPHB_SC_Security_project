package Service;

import Models.Users.Permissions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 18-11-2021 - 12:56
 **/
class RegisterServiceTest {
@Test
    void registerNewUser() throws Exception {
        RegisterService registerService = new RegisterService();
    List<Permissions> permissions = new ArrayList<>();
    Permissions permissions1 = new Permissions("View Personal Page", Permissions.UserPermissions.VIEW_PERSONAL_USER_PAGE);
    Permissions permissions2 = new Permissions("Add products to basket", Permissions.UserPermissions.ADD_TO_BASKET);
    Permissions permissions3 = new Permissions("Upload profile picture", Permissions.UserPermissions.UPLOAD_PROFILE_PICTURE);
    Permissions permissions4 = new Permissions("VIEW ADMIN PAGE", Permissions.UserPermissions.VIEW_ADMIN_PAGE);
   permissions.add(permissions1);
    permissions.add(permissions2);
    permissions.add(permissions3);
    permissions.add(permissions4);
    registerService.registerUser("mathiastouboel@gmail.com", "password");





}

    @Test
    void checkIfInSystem() throws Exception {
        RegisterService registerService = new RegisterService();

    }
}
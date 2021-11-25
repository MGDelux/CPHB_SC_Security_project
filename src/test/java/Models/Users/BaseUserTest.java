package Models.Users;

import org.junit.jupiter.api.Test;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CREATED BY mathias @ 25-11-2021 - 14:09
 **/
class BaseUserTest {

    @Test
    void checkForPermission() {
        BaseUser user = new BaseUser("email@email.com","pw");
        List<Permissions> permissions = new ArrayList<>();
        Customer customer = new Customer(true,2500);
        user.setCustomerInfomation(customer);
        Permissions permissions1 = new Permissions("View Personal Page", Permissions.UserPermissions.VIEW_PERSONAL_USER_PAGE);
        Permissions permissions2 = new Permissions("Add products to basket", Permissions.UserPermissions.ADD_TO_BASKET);
        Permissions permissions3 = new Permissions("Upload profile picture", Permissions.UserPermissions.UPLOAD_PROFILE_PICTURE);
        permissions.add(permissions1);
        permissions.add(permissions2);
        permissions.add(permissions3);
        user.setUserPermissions(permissions);
        user.checkForPermission(Permissions.UserPermissions.ADD_TO_BASKET);
        user.checkForPermission(Permissions.UserPermissions.DELETE_PRODUCT);


    }

}
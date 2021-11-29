package Models.Users;

import javax.persistence.*;

/**
 * CREATED BY mathias @ 13-11-2021 - 21:41
 **/
@Entity(name = "Permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int permissionID;
    private String permissionDescription;
    @Enumerated(EnumType.ORDINAL)
    private UserPermissions userPerms;

    public Permissions() {

    }

    public Permissions(String permissionDescription, UserPermissions permissions) {
        this.permissionDescription = permissionDescription;
        this.userPerms = permissions;
    }

    public UserPermissions getUserPerms() {
        return userPerms;
    }

    public int getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(int permissionID) {
        this.permissionID = permissionID;
    }

    public UserPermissions getUsersPermissions() {
        return userPerms;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permissionID=" + permissionID +
                ", permissionDescription='" + permissionDescription + '\'' +
                ", permissions=" + userPerms +
                '}';
    }

    public enum UserPermissions {
        //NOTE THIS PERMISSIONS ARE MEANT FOR WEBSITE BASED CHANGES NOT DATABASE CHECK InternalPermissions.Class
        CREATE_PRODUCT,
        DELETE_PRODUCT,
        ADD_PRODUCT,
        UPLOAD_PROFILE_PICTURE,
        DELETE_USER,
        MODIFY_USER,
        ADD_TO_BASKET,
        VIEW_ADMIN_PAGE,
        VIEW_PERSONAL_USER_PAGE

    }
}


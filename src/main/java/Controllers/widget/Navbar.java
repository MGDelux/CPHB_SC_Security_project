package Controllers.widget;

import Models.Users.Permissions;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CREATED BY mathias @ 16-11-2021 - 12:12
 **/
public class Navbar {
    private final HttpServletRequest request;

    public Navbar(HttpServletRequest request) {
        this.request = request;
    }
    private final List<Navbar.NavItems> navLinks = Arrays.asList(
            new NavItems("Hjem", "/", null),
            new NavItems("Prodcuts", "/products", null),
            new NavItems("ProfilePage", "/Profile", Permissions.UserPermissions.VIEW_PERSONAL_USER_PAGE),
            new NavItems("AdminPage", "/Admin", Permissions.UserPermissions.VIEW_ADMIN_PAGE));

public List<NavItems> getNavLinks() {
    List<Navbar.NavItems> navlinks = new ArrayList<>();
    List<Permissions.UserPermissions> userPerms = (List<Permissions.UserPermissions>) request.getSession().getAttribute("userPermissions");
    for (Navbar.NavItems item: navLinks){
   if (userPerms.contains(item.userPermission)){
       navlinks.add(item);
   }
    }
    return navLinks;
}



    public class NavItems {
        private final String description;
        private final String url;
        private final Permissions.UserPermissions userPermission;

        public NavItems(String description, String url, Permissions.UserPermissions userPermission) {
            this.description = description;
            this.url = url;
            this.userPermission = userPermission;
        }

        public String getDescription() {
            return description;
        }

        public String getUrl() {
            return url;
        }

        public Permissions.UserPermissions getUserPermission() {
            return userPermission;
        }

        public boolean isActive() {
            return request.getRequestURI().endsWith(url);
        }

    }
}

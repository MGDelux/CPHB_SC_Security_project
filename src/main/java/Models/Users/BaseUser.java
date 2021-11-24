package Models.Users;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity(name="Users")
public class BaseUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="User_ID" , unique = true, length = 56)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.email}")
    @Column(name="Email" , unique = true, length = 56)
    protected String email;
    @Column(name="Name")
    private String username;
    @NotNull
    @Size(min = 5, max = 255)
    @Column(name="Password")
    private String saltedPassword;
    @Column(name="ProfilePicture")
    private byte[] profilePicture; //we store images as bytes for db
    @OneToMany(targetEntity = Permissions.class,cascade = CascadeType.PERSIST,fetch =  FetchType.EAGER)
    private List<Permissions> userPermissions;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Customer customerInfomation;
    @Column(name="Login_status")
    private boolean isLoggedIn;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getSaltedPassword() {
        return saltedPassword;
    }

    public BaseUser(@NotNull @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "{invalid.email}") String email, @NotNull String saltedPassword) {
        this.email = email;
        this.saltedPassword = BCrypt.hashpw(saltedPassword,BCrypt.gensalt(15));
    }

    public BaseUser() {

    }


    public void setUserPermissions(List<Permissions> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public void addPermissionToUser(Permissions perm) throws Exception {
        try {
            userPermissions.add(perm);
        }catch (Exception e){
            throw new Exception("ERROR"); //TODO CUSTOM EXCEPTION
        }

    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean checkForPermission(Permissions.UserPermissions permission){
        for (Permissions p: this.getUserPermissions()){
            if (p.getUsersPermissions().equals(permission)){
                return true;
            }
        }
        return false;
    }

    public List<Permissions> getUserPermissions() {
        return userPermissions;
    }

    public String getUsername() {
        return username;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public Customer getCustomerInfomation() {
        return customerInfomation;
    }

    public void setCustomerInfomation(Customer customerInfomation) {
        this.customerInfomation = customerInfomation;
    }

//TODO DTO TOSTRING()

    @Override
    public String toString() {
        return "BaseUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", saltedPassword='" + saltedPassword + '\'' +
                ", profilePicture=" + Arrays.toString(profilePicture) +
                ", userPermissions=" + userPermissions +
                ", customerInfomation=" + customerInfomation +
                '}';
    }
}

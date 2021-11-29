package Config.ErrorHandling;

public class UserAlreadyExisting extends Exception {

    public UserAlreadyExisting(String message) {
        super(message);
    }


    public UserAlreadyExisting() {
        super("This infomation is already in use. do login");
    }
}

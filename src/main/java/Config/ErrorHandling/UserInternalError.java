package Config.ErrorHandling;

public class UserInternalError extends Exception{

    public UserInternalError(String message) {
        super(message);
    }


    public UserInternalError() {
        super("Internal Error.");
    }
}

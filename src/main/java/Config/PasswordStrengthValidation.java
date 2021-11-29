package Config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CREATED BY mathias @ 21-11-2021 - 16:09
 **/
public class PasswordStrengthValidation {
    /**
     * MUST ATLEAST CONTAIN 1, 1 DIGTET NUMBER
     * ATLEST 1 LOWER CASE LETTER
     * ATLEAST 1 UPPER CAsE LETTER
     * 1 SPECIAL CHAR  ! @ # & ( )
     * ATLEAST 8 CHARS LONG MAX 25
     **/
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,25}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean ValidatePWStrength(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

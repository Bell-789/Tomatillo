package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Chris
 */
public class Validadores {

    public boolean validaRfc(String rfc) {
        String regex = "^[a-zA-Z]{4}[0-9]{6}[a-zA-Z0-9]{3}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(rfc);

        return matcher.matches();
    }
}

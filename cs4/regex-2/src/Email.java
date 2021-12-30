import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    private boolean validate() {
        int indexAt = email.indexOf('@');
        //if has no domain invalid
        if (indexAt < 0)
            return false;
        //separate the local and domain into diff strings for matching
        String local = email.substring(0, indexAt);
        String domain = email.substring(indexAt + 1);
        return (checkLocal(local) && checkDomain(domain));
    }

    private boolean checkLocal(String local) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9!#$%&'*+\\-\\./=?^_`{|}~]+$");
        Matcher matcher = pattern.matcher(local);
        //check for dot placement and quantity in local
        return matcher.matches() && checkDots(local);
    }

    private boolean checkDots(String local) {
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(local);
        if (matcher.find()) {
            //if there's a dot at start, end, or more than one dot return true
            if (matcher.start() == 0)
                return false;
            else if (matcher.start() == local.length() - 1)
                return false;
            else if (matcher.find())
                return false;
        }
        return true;
    }

    private boolean checkDomain(String domain) {
        boolean valid = false;
        Pattern pattern = Pattern.compile("^([\\w\\-]+)(\\.[a-z]{2,3})+$");
        Matcher matcher = pattern.matcher(domain);
        if (matcher.matches())
            valid = true;

        return valid;
    }

    public String toString() {
        String out = "Email is ";
        out += validate() ? "valid : " : "invalid : ";
        return out + email;
    }
}
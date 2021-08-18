package password;

public class PasswordSimple extends Password {
    public PasswordSimple() {

        super("[a-zA-Z]{5,15}");
    }
}

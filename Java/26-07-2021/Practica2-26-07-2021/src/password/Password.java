package password;

import java.util.regex.Pattern;

public class Password {

    private String regex;
    private String password;

    public Password(String regex){
        this.regex = regex;

    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        try
        {
            if (!Pattern.compile(this.regex).matcher(password).matches())
                throw new IllegalAccessException("Contraseña no valida");
        }
        catch (IllegalAccessException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(0);
        }

        this.password = password;
    }
}

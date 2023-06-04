package behavioral.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public class RegistrationFormErrors {

    private final List<String> loginErrors;
    private final List<String> passwordErrors;
    private final List<String> passwordConfirmErrors;
    private final List<String> emailErrors;

    public RegistrationFormErrors() {
        loginErrors = new ArrayList<>();
        passwordErrors = new ArrayList<>();
        passwordConfirmErrors = new ArrayList<>();
        emailErrors = new ArrayList<>();
    }

    public boolean isOk() {
        return loginErrors.isEmpty()
                && passwordErrors.isEmpty()
                && passwordConfirmErrors.isEmpty()
                && emailErrors.isEmpty();
    }

    public List<String> getLoginErrors() {
        return loginErrors;
    }

    public List<String> getPasswordErrors() {
        return passwordErrors;
    }

    public List<String> getPasswordConfirmErrors() {
        return passwordConfirmErrors;
    }

    public List<String> getEmailErrors() {
        return emailErrors;
    }

    public void addToLoginErrors(String error) {
        loginErrors.add(error);
    }

    public void addToPasswordErrors(String error) {
        passwordErrors.add(error);
    }

    public void addToPasswordConfirmErrors(String error) {
        passwordConfirmErrors.add(error);
    }

    public void addToEmailErrors(String error) {
        emailErrors.add(error);
    }


}

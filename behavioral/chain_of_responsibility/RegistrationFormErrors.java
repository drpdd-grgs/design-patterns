package behavioral.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public class RegistrationFormErrors {

    private final List<String> loginErrors;
    private final List<String> passwordErrors;
    private final List<String> passwordConfirmErrors;
    private final List<String> emailErrors;

    public RegistrationFormErrors() {
        this.loginErrors = new ArrayList<>();
        this.passwordErrors = new ArrayList<>();
        this.passwordConfirmErrors = new ArrayList<>();
        this.emailErrors = new ArrayList<>();
    }

    public boolean isOk() {
        return this.loginErrors.isEmpty()
                && this.passwordErrors.isEmpty()
                && this.passwordConfirmErrors.isEmpty()
                && this.emailErrors.isEmpty();
    }

    public List<String> getLoginErrors() {
        return this.loginErrors;
    }

    public List<String> getPasswordErrors() {
        return this.passwordErrors;
    }

    public List<String> getPasswordConfirmErrors() {
        return this.passwordConfirmErrors;
    }

    public List<String> getEmailErrors() {
        return this.emailErrors;
    }

    public void addToLoginErrors(String error) {
        this.loginErrors.add(error);
    }

    public void addToPasswordErrors(String error) {
        this.passwordErrors.add(error);
    }

    public void addToPasswordConfirmErrors(String error) {
        this.passwordConfirmErrors.add(error);
    }

    public void addToEmailErrors(String error) {
        this.emailErrors.add(error);
    }


}

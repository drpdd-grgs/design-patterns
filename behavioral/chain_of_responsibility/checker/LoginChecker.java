package behavioral.chain_of_responsibility.checker;

import behavioral.chain_of_responsibility.RegistrationForm;
import behavioral.chain_of_responsibility.RegistrationFormErrors;

import java.util.regex.Pattern;

public class LoginChecker extends Checker {

    private static final Pattern LOGIN_PATTERN = Pattern.compile("[a-zA-Z0-9]{8,20}");

    @Override
    public void check(RegistrationForm registrationForm, RegistrationFormErrors registrationFormErrors) {
        String login = registrationForm.getLogin();
        if (checkEmpty(login)) {
            registrationFormErrors.addToLoginErrors("Login is empty");
        } else {
            if (!checkLogin(login)) {
                registrationFormErrors.addToLoginErrors("Login can only contains digits and latin symbols and must have length of at least 8 characters and a maximum of 20 characters");
            }
        }
        checkNext(registrationForm, registrationFormErrors);
    }

    private boolean checkLogin(String login) {
        return LOGIN_PATTERN.matcher(login).matches();
    }

}

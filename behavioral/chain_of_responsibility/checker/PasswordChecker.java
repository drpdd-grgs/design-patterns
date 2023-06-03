package behavioral.chain_of_responsibility.checker;

import behavioral.chain_of_responsibility.RegistrationForm;
import behavioral.chain_of_responsibility.RegistrationFormErrors;

import java.util.regex.Pattern;

public class PasswordChecker extends Checker {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");

    @Override
    public void check(RegistrationForm registrationForm, RegistrationFormErrors registrationFormErrors) {
        String password = registrationForm.getPassword();
        if (checkEmpty(password)) {
            registrationFormErrors.addToPasswordErrors("Password is empty");
        } else {
            if (!checkPassword(password)) {
                registrationFormErrors.addToPasswordErrors("Password must contain one uppercase and lowercase character, at least 1 digit, special character and must have length of at least 8 characters and a maximum of 20 characters");
            }
        }
        checkNext(registrationForm, registrationFormErrors);
    }

    private boolean checkPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

}

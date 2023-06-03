package behavioral.chain_of_responsibility.checker;

import behavioral.chain_of_responsibility.RegistrationForm;
import behavioral.chain_of_responsibility.RegistrationFormErrors;

import java.util.regex.Pattern;

public class EmailChecker extends Checker {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public void check(RegistrationForm registrationForm, RegistrationFormErrors registrationFormErrors) {
        String email = registrationForm.getEmail();
        if (checkEmpty(email)) {
            registrationFormErrors.addToEmailErrors("Email is empty");
        } else {
            if (!checkEmail(email)) {
                registrationFormErrors.addToEmailErrors("Email is not correct");
            }
        }
        checkNext(registrationForm, registrationFormErrors);
    }

    private boolean checkEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

}

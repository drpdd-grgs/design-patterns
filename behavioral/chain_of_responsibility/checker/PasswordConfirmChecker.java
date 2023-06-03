package behavioral.chain_of_responsibility.checker;

import behavioral.chain_of_responsibility.RegistrationForm;
import behavioral.chain_of_responsibility.RegistrationFormErrors;

public class PasswordConfirmChecker extends Checker {

    @Override
    public void check(RegistrationForm registrationForm, RegistrationFormErrors registrationFormErrors) {
        String password = registrationForm.getPassword();
        String passwordConfirm = registrationForm.getPasswordConfirm();
        if (registrationFormErrors.getPasswordErrors().isEmpty() &&
                (checkEmpty(passwordConfirm) || !password.equals(passwordConfirm))) {
            registrationFormErrors.addToPasswordConfirmErrors("Passwords are not equals");
        }
        checkNext(registrationForm, registrationFormErrors);
    }

}

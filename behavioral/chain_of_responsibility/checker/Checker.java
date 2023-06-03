package behavioral.chain_of_responsibility.checker;

import behavioral.chain_of_responsibility.RegistrationForm;
import behavioral.chain_of_responsibility.RegistrationFormErrors;

public abstract class Checker {

    private Checker next;

    public Checker linkWith(Checker next) {
        this.next = next;
        return next;
    }

    public abstract void check(RegistrationForm registrationForm, RegistrationFormErrors registrationFormErrors);

    protected void checkNext(RegistrationForm registrationForm, RegistrationFormErrors registrationFormErrors) {
        if (next == null) {
            return;
        }
        next.check(registrationForm, registrationFormErrors);
    }

    protected boolean checkEmpty(String toCheck) {
        return toCheck == null || toCheck.length() == 0;
    }

}

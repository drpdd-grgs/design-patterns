package behavioral.chain_of_responsibility;

public class RegistrationForm {

    private String login;
    private String password;
    private String passwordConfirm;
    private String email;

    private RegistrationForm() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {

        private final RegistrationForm registrationForm;

        private Builder() {
            registrationForm = new RegistrationForm();
        }

        public RegistrationForm build() {
            return registrationForm;
        }

        public Builder login(String login) {
            registrationForm.login = login;
            return this;
        }

        public Builder password(String password) {
            registrationForm.password = password;
            return this;
        }

        public Builder passwordConfirm(String passwordConfirm) {
            registrationForm.passwordConfirm = passwordConfirm;
            return this;
        }

        public Builder email(String email) {
            registrationForm.email = email;
            return this;
        }

    }

}

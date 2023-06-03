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
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPasswordConfirm() {
        return this.passwordConfirm;
    }

    public String getEmail() {
        return this.email;
    }

    public static class Builder {

        private final RegistrationForm registrationForm;

        private Builder() {
            this.registrationForm = new RegistrationForm();
        }

        public RegistrationForm build() {
            return this.registrationForm;
        }

        public Builder login(String login) {
            this.registrationForm.login = login;
            return this;
        }

        public Builder password(String password) {
            this.registrationForm.password = password;
            return this;
        }

        public Builder passwordConfirm(String passwordConfirm) {
            this.registrationForm.passwordConfirm = passwordConfirm;
            return this;
        }

        public Builder email(String email) {
            this.registrationForm.email = email;
            return this;
        }

    }

}

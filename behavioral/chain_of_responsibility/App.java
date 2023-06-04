package behavioral.chain_of_responsibility;

import behavioral.chain_of_responsibility.checker.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Chain of Responsibility");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Registration form validator");
        headerPanel.add(headerLabel);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;

        JLabel loginLabel = new JLabel("Enter login: ");
        JLabel passwordLabel = new JLabel("Enter password: ");
        JLabel passwordConfirmLabel = new JLabel("Confirm password: ");
        JLabel emailLabel = new JLabel("Enter email: ");

        JTextField loginInput = new JTextField(20);
        JPasswordField passwordInput = new JPasswordField(20);
        JPasswordField passwordConfirmInput = new JPasswordField(20);
        JTextField emailInput = new JTextField(20);

        panel.add(loginLabel, constraints);
        constraints.gridx = 1;
        panel.add(loginInput, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);
        constraints.gridx = 1;
        panel.add(passwordInput, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(passwordConfirmLabel, constraints);
        constraints.gridx = 1;
        panel.add(passwordConfirmInput, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(emailLabel, constraints);
        constraints.gridx = 1;
        panel.add(emailInput, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton validateButton = new JButton("Validate");
        validateButton.addActionListener(e -> {
            RegistrationForm form = RegistrationForm.builder()
                    .login(loginInput.getText())
                    .password(passwordInput.getText())
                    .passwordConfirm(passwordConfirmInput.getText())
                    .email(emailInput.getText())
                    .build();
            RegistrationFormErrors errors = new RegistrationFormErrors();

            Checker checkerChain = new LoginChecker();
            checkerChain.linkWith(new PasswordChecker())
                    .linkWith(new PasswordConfirmChecker())
                    .linkWith(new EmailChecker());

            checkerChain.check(form, errors);

            if (errors.isOk()) {
                JOptionPane.showMessageDialog(frame, "Form is correct");
            } else {
                StringBuilder sb = new StringBuilder();
                if (!errors.getLoginErrors().isEmpty()) {
                    fillErrors("Login", errors.getLoginErrors(), sb);
                }
                if (!errors.getPasswordErrors().isEmpty()) {
                    fillErrors("Password", errors.getPasswordErrors(), sb);
                }
                if (!errors.getPasswordConfirmErrors().isEmpty()) {
                    fillErrors("PasswordConfirm", errors.getPasswordConfirmErrors(), sb);
                }
                if (!errors.getEmailErrors().isEmpty()) {
                    fillErrors("Email", errors.getEmailErrors(), sb);
                }
                JOptionPane.showMessageDialog(frame, sb);
            }
        });
        panel.add(validateButton, constraints);

        mainPanel.add(headerPanel);
        mainPanel.add(panel);

        frame.add(mainPanel);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void fillErrors(String name, List<String> errors, StringBuilder sb) {
        sb.append(name);
        sb.append(" errors:\n");
        for (String error : errors) {
            sb.append(error);
            sb.append("\n");
        }
        sb.append("\n");
    }

}

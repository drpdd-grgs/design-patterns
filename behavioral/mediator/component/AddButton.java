package behavioral.mediator.component;

import behavioral.mediator.mediator.Mediator;
import behavioral.mediator.mediator.User;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddButton extends JButton implements Component {

    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        String userName = JOptionPane.showInputDialog("Input UserName");
        if (mediator.userExists(userName)) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "User with name: " + userName + " already exists!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            mediator.addUser(new User(userName));
        }
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override public String getName() {
        return "AddButton";
    }

}

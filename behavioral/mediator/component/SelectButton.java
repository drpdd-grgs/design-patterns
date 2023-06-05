package behavioral.mediator.component;

import behavioral.mediator.mediator.Mediator;
import behavioral.mediator.mediator.User;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectButton extends JButton implements Component {

    private Mediator mediator;

    public SelectButton() {
        super("Select");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        User user = mediator.getSelectedUser();
        if (user != null) {
            mediator.sendUserToTitle(user);
        }
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override public String getName() {
        return "SelectButton";
    }

}

package behavioral.mediator.component;

import behavioral.mediator.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteButton extends JButton implements Component {

    private Mediator mediator;

    public DeleteButton() {
        super("Delete");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.deleteUser();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override public String getName() {
        return "DeleteButton";
    }

}

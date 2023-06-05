package behavioral.memento.component;

import behavioral.memento.editor.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddButton extends JButton implements Component {

    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.save();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String displayName() {
        return "AddButton";
    }

}

package behavioral.memento.component;

import behavioral.memento.editor.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteButton extends JButton implements Component {

    private Mediator mediator;

    public DeleteButton() {
        super("Delete");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.delete();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String displayName() {
        return "DeleteButton";
    }

}

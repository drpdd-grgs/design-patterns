package behavioral.memento.component;

import behavioral.memento.editor.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RestoreButton extends JButton implements Component {

    private Mediator mediator;

    public RestoreButton() {
        super("Restore");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.restore();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String displayName() {
        return "RestoreButton";
    }

}

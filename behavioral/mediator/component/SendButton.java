package behavioral.mediator.component;

import behavioral.mediator.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SendButton extends JButton implements Component {

    private Mediator mediator;

    public SendButton() {
        super("Send");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.sendMessage();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "SendButton";
    }

}

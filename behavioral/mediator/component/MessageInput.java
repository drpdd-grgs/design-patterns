package behavioral.mediator.component;

import behavioral.mediator.mediator.Mediator;

import javax.swing.*;

public class MessageInput extends JTextArea implements Component {

    private Mediator mediator;

    public MessageInput() {
        super();
    }

    public String getMessage() {
        return this.getText();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "MessageInput";
    }

}

package behavioral.mediator.component;

import behavioral.mediator.mediator.Mediator;
import behavioral.mediator.mediator.User;

import javax.swing.*;
import java.time.LocalDateTime;

public class MessageBox extends JTextArea implements Component {

    private Mediator mediator;

    public void getMessage(User sender, String message) {
        this.append(sender.getName() + " [" + LocalDateTime.now() + "]: " + message + "\n");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "MessageBox";
    }

}

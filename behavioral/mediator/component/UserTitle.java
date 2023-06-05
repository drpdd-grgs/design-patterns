package behavioral.mediator.component;

import behavioral.mediator.mediator.Mediator;
import behavioral.mediator.mediator.User;

import javax.swing.*;

public class UserTitle extends JTextField implements Component {

    private Mediator mediator;
    private User selectedUser;

    public UserTitle() {
        super();
        setEditable(false);
    }

    public void setUser(User user) {
        setText(user.getName());
        selectedUser = user;
    }

    public void clearUser() {
        selectedUser = null;
        setText("");
    }

    public User getUser() {
        return selectedUser;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "UserTitle";
    }

}

package behavioral.mediator.component;

import behavioral.mediator.mediator.Mediator;
import behavioral.mediator.mediator.User;

import javax.swing.*;

public class UserList extends JList implements Component {

    private Mediator mediator;
    private final DefaultListModel listModel;

    public UserList(DefaultListModel listModel) {
        super(listModel);
        this.listModel = listModel;
        setModel(listModel);
        setLayoutOrientation(VERTICAL);
    }

    public void addUser(User user) {
        listModel.addElement(user);
        int index = listModel.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
    }

    public boolean userExists(String userName) {
        return listModel.indexOf(new User(userName)) != -1;
    }

    public void deleteUser() {
        int index = this.getSelectedIndex();
        try {
            listModel.remove(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            // ignored
        }
    }

    public User getSelectedUser() {
        return (User) getSelectedValue();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "UserList";
    }

}

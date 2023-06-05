package behavioral.mediator.mediator;

import behavioral.mediator.component.Component;

public interface Mediator {

    void addUser(User user);
    boolean userExists(String userName);
    void deleteUser();
    User getSelectedUser();
    void sendUserToTitle(User user);
    void sendMessage();
    void init();
    void addComponent(Component component);

}

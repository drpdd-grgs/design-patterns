package behavioral.mediator;

import behavioral.mediator.component.*;
import behavioral.mediator.mediator.Editor;
import behavioral.mediator.mediator.Mediator;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        Mediator mediator = new Editor();
        mediator.addComponent(new UserList(new DefaultListModel()));
        mediator.addComponent(new AddButton());
        mediator.addComponent(new DeleteButton());
        mediator.addComponent(new SelectButton());
        mediator.addComponent(new UserTitle());
        mediator.addComponent(new MessageInput());
        mediator.addComponent(new MessageBox());
        mediator.addComponent(new SendButton());
        mediator.init();
    }

}

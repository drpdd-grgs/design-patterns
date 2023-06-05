package behavioral.memento;

import behavioral.memento.component.*;
import behavioral.memento.editor.Editor;
import behavioral.memento.editor.Mediator;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        Mediator mediator = new Editor();
        mediator.registerComponent(new MementoList(new DefaultListModel()));
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new RestoreButton());
        mediator.registerComponent(new TextEditor());
        mediator.init();
    }

}

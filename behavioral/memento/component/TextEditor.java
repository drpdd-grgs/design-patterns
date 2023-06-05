package behavioral.memento.component;

import behavioral.memento.editor.Mediator;

import javax.swing.*;

public class TextEditor extends JTextArea implements Component {

    private Mediator mediator;

    public String getState() {
        return this.getText();
    }

    public void setState(String state) {
        this.setText(state);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String displayName() {
        return "TextEditor";
    }

}

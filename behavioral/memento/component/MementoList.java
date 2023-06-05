package behavioral.memento.component;

import behavioral.memento.editor.Mediator;
import behavioral.memento.editor.Memento;

import javax.swing.*;

public class MementoList extends JList implements Component {

    private Mediator mediator;
    private final DefaultListModel listModel;

    public MementoList(DefaultListModel listModel) {
        super(listModel);
        this.listModel = listModel;
        setModel(listModel);
        setLayoutOrientation(VERTICAL);
    }

    public void addMemento(Memento memento) {
        listModel.addElement(memento);
        int index = listModel.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
    }

    public void deleteMemento() {
        int index = this.getSelectedIndex();
        try {
            listModel.remove(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            // ignored
        }
    }

    public Memento getSelectedMemento() {
        return (Memento) getSelectedValue();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String displayName() {
        return "MementoList";
    }

}

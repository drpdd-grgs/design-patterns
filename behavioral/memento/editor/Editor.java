package behavioral.memento.editor;

import behavioral.memento.component.*;
import behavioral.memento.component.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Editor implements Mediator {

    private MementoList mementoList;
    private AddButton addButton;
    private DeleteButton deleteButton;
    private RestoreButton restoreButton;
    private TextEditor textEditor;

    @Override
    public String backup() {
        return textEditor.getState();
    }

    @Override
    public void save() {
        mementoList.addMemento(new Memento(this));
    }

    @Override
    public void restore() {
        Memento memento = mementoList.getSelectedMemento();
        textEditor.setState(memento.getBackup());
    }

    @Override
    public void delete() {
        mementoList.deleteMemento();
    }

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.displayName()) {
            case "MementoList":
                mementoList = (MementoList) component;
                break;
            case "AddButton":
                addButton = (AddButton) component;
                break;
            case "DeleteButton":
                deleteButton = (DeleteButton) component;
                break;
            case "RestoreButton":
                restoreButton = (RestoreButton) component;
                break;
            case "TextEditor":
                textEditor = (TextEditor) component;
                break;
        }
    }

    @Override
    public void init() {
        JFrame frame = new JFrame("Memento");
        frame.setSize(960, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel left = new JPanel();
        left.setBorder(new LineBorder(Color.BLACK));
        left.setSize(320, 600);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JPanel mementoListPanel = new JPanel();
        mementoList.setFixedCellWidth(260);
        mementoList.setSize(320, 470);
        JScrollPane scrollPane = new JScrollPane(mementoList);
        scrollPane.setPreferredSize(new Dimension(275, 410));
        mementoListPanel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        addButton.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(addButton);
        deleteButton.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(deleteButton);
        restoreButton.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(restoreButton);

        left.add(mementoListPanel);
        left.add(buttonPanel);

        JPanel right = new JPanel();
        right.setLayout(null);
        right.setSize(640, 600);
        right.setLocation(320, 0);
        right.setBorder(new LineBorder(Color.BLACK));

        textEditor.setBorder(new LineBorder(Color.DARK_GRAY));
        textEditor.setBounds(20, 20, 595, 400);

        right.add(textEditor);

        frame.setLayout(null);
        frame.getContentPane().add(left);
        frame.getContentPane().add(right);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

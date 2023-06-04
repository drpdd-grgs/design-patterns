package behavioral.command.editor;

import behavioral.command.commands.*;

import javax.swing.*;
import java.awt.*;

public class Editor {

    private JLabel label;
    private final CommandHistory history;

    public Editor() {
        this.history = new CommandHistory();
    }

    public void init() {
        JFrame frame = new JFrame("Command");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton moveLeft = new JButton("Move Left");
        JButton moveRight = new JButton("Move Right");
        JButton moveUp = new JButton("Move Up");
        JButton moveDown = new JButton("Move Down");
        JButton undo = new JButton("Undo");

        Editor editor = this;

        moveLeft.addActionListener(e -> executeCommand(new MoveLeftCommand(editor)));
        moveRight.addActionListener(e -> executeCommand(new MoveRightCommand(editor)));
        moveUp.addActionListener(e -> executeCommand(new MoveUpCommand(editor)));
        moveDown.addActionListener(e -> executeCommand(new MoveDownCommand(editor)));
        undo.addActionListener(e -> undo());

        JPanel field = new JPanel(new GridBagLayout());
        this.label = new JLabel("MOVE ME");
        this.label.setLocation(250, 250);
        field.add(label);

        buttons.add(moveLeft);
        buttons.add(moveRight);
        buttons.add(moveUp);
        buttons.add(moveDown);
        buttons.add(undo);

        content.add(buttons);
        content.add(field);

        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Point getLabelLocation() {
        return this.label.getLocation();
    }

    public void setLabelLocation(Point p) {
        this.label.setLocation(p);
    }

    private void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    private void undo() {
        if (history.isEmpty()) {
            return;
        }
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

}

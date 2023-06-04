package behavioral.command.commands;

import behavioral.command.editor.Editor;

import java.awt.*;

public class MoveLeftCommand extends Command {

    public MoveLeftCommand(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        backup();
        Point currentLocation = editor.getLabelLocation();
        editor.setLabelLocation(new Point(currentLocation.x - 5, currentLocation.y));
    }

}

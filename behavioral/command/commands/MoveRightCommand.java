package behavioral.command.commands;

import behavioral.command.editor.Editor;

import java.awt.*;

public class MoveRightCommand extends Command {

    public MoveRightCommand(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        backup();
        Point currentLocation = editor.getLabelLocation();
        editor.setLabelLocation(new Point(currentLocation.x + 5, currentLocation.y));
    }

}

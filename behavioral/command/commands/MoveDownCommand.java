package behavioral.command.commands;

import behavioral.command.editor.Editor;

import java.awt.*;

public class MoveDownCommand extends Command {

    public MoveDownCommand(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        backup();
        Point currentLocation = this.editor.getLabelLocation();
        this.editor.setLabelLocation(new Point(currentLocation.x, currentLocation.y + 5));
    }

}

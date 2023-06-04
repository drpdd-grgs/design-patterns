package behavioral.command.commands;

import behavioral.command.editor.Editor;

import java.awt.*;

public abstract class Command {

    protected Editor editor;
    private Point backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public void backup() {
        backup = editor.getLabelLocation();
    }

    public void undo() {
        editor.setLabelLocation(backup);
    }

    public abstract void execute();

}

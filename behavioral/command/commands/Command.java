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
        this.backup = this.editor.getLabelLocation();
    }

    public void undo() {
        this.editor.setLabelLocation(backup);
    }

    public abstract void execute();

}

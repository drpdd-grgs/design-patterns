package behavioral.memento.editor;

import java.time.Instant;

public class Memento {

    private final String backup;
    private final Editor editor;
    private final String name;

    public Memento(Editor editor) {
        this.editor = editor;
        backup = editor.backup();
        name = Instant.now().toString();
    }

    public String getBackup() {
        return backup;
    }

    @Override
    public String toString() {
        return name;
    }

}

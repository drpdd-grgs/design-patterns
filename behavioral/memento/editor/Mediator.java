package behavioral.memento.editor;

import behavioral.memento.component.Component;

public interface Mediator {

    void init();
    void registerComponent(Component component);
    String backup();
    void save();
    void restore();
    void delete();

}

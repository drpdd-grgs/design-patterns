package behavioral.memento.component;

import behavioral.memento.editor.Mediator;

public interface Component {

    void setMediator(Mediator mediator);
    String displayName();

}

package behavioral.command.commands;

import java.util.Stack;

public class CommandHistory {

    private final Stack<Command> history;

    public CommandHistory() {
        this.history = new Stack<>();
    }

    public void push(Command c) {
        this.history.push(c);
    }

    public Command pop() {
        return this.history.pop();
    }

    public boolean isEmpty() {
        return this.history.isEmpty();
    }

}

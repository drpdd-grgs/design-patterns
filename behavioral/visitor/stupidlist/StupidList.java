package behavioral.visitor.stupidlist;

public class StupidList<T> {

    protected Node head;
    protected Node tail;
    private State state;

    public StupidList() {
        this.state = new EmptyState(this);
    }

    protected void changeState(State state) {
        this.state = state;
    }

    public void add(T value) {
        state.add(value);
    }

    public void remove() {
        state.remove();
    }

    public void accept(Visitor visitor) {
        state.accept(visitor);
    }

}

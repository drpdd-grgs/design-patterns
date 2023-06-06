package behavioral.visitor.stupidlist;

public abstract class State<T> {

    protected StupidList<T> stupidList;

    public State(StupidList<T> stupidList) {
        this.stupidList = stupidList;
    }

    abstract void add(T value);

    abstract void remove();

    abstract void accept(Visitor visitor);

}

package behavioral.state.stupidlist;

public class EmptyState<T> extends State<T> {

    public EmptyState(StupidList<T> stupidList) {
        super(stupidList);
    }

    @Override
    void add(T value) {
        Node node = new Node(value);
        stupidList.head = node;
        stupidList.tail = node;
        stupidList.head.setNext(stupidList.tail);
        stupidList.tail.setNext(stupidList.head);
        stupidList.changeState(new SingleElementState(stupidList));
    }

    @Override
    void remove() {
        throw new IllegalStateException("List is empty");
    }

}

package behavioral.visitor.stupidlist;

public class SingleElementState<T> extends State<T> {

    public SingleElementState(StupidList<T> stupidList) {
        super(stupidList);
    }

    @Override
    void add(T value) {
        Node node = new Node(value);
        stupidList.tail.setNext(node);
        stupidList.tail = node;
        stupidList.tail.setNext(stupidList.head);
        stupidList.changeState(new MultiElementState(stupidList));
    }

    @Override
    void remove() {
        stupidList.head = null;
        stupidList.tail = null;
        stupidList.changeState(new EmptyState(stupidList));
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitSingle(stupidList);
    }

}

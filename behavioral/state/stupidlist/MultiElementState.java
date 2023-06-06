package behavioral.state.stupidlist;

public class MultiElementState<T> extends State<T> {

    public MultiElementState(StupidList<T> stupidList) {
        super(stupidList);
    }

    @Override
    void add(T value) {
        Node node = new Node(value);
        stupidList.tail.setNext(node);
        stupidList.tail = node;
        stupidList.tail.setNext(stupidList.head);
    }

    @Override
    void remove() {
        Node prev = stupidList.head;
        while (prev.getNext() != stupidList.tail) {
            prev = prev.getNext();
        }
        stupidList.tail = prev;
        stupidList.tail.setNext(stupidList.head);
        if (stupidList.tail.equals(stupidList.head)) {
            stupidList.changeState(new SingleElementState(stupidList));
        }
    }

}

package behavioral.state.stupidlist;

public class Node<T> {

    private final T value;
    private Node next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    void setNext(Node value) {
        next = value;
    }

}

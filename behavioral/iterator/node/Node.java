package behavioral.iterator.node;

public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        left = node;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        right = node;
    }

}

package behavioral.iterator.node;

import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree {

    private Node root;

    private BinaryTree() {

    }

    public static BinaryTree create(int[] array) {
        BinaryTree tree = new BinaryTree();
        for (int item : array) {
            tree.add(item);
        }
        return tree;
    }

    public Iterator iterator() {
        return new Iterator(root);
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private Node addRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.getValue()) {
            node.setLeft(addRecursive(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(addRecursive(node.getRight(), value));
        } else {
            return node;
        }

        return node;
    }

    private Node deleteRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value == node.getValue()) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            int smallestValue = findSmallestValue(node.getRight());
            node.setValue(smallestValue);
            node.setRight(deleteRecursive(node.getRight(), smallestValue));
            return node;
        }
        if (value < node.getValue()) {
            node.setLeft(deleteRecursive(node.getLeft(), value));
        } else {
            node.setRight(deleteRecursive(node.getRight(), value));
        }
        return node;
    }

    private boolean containsRecursive(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        return value < node.getValue()
                ? containsRecursive(node.getLeft(), value)
                : containsRecursive(node.getRight(), value);
    }

    private int findSmallestValue(Node node) {
        return node.getLeft() == null ? node.getValue() : findSmallestValue(node.getLeft());
    }

    public static class Iterator {

        private final Stack<Node> traversal;

        private Iterator(Node root) {
            traversal = new Stack<>();
            moveLeft(root);
        }

        private void moveLeft(Node node) {
            while (node != null) {
                traversal.push(node);
                node = node.getLeft();
            }
        }

        public boolean hasNext() {
            return !traversal.isEmpty();
        }

        public Node next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node node = traversal.pop();
            if (node.getRight() != null) {
                moveLeft(node.getRight());
            }
            return node;
        }

    }

}

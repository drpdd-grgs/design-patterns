package behavioral.iterator;

import behavioral.iterator.node.BinaryTree;
import behavioral.iterator.node.Iterator;
import behavioral.iterator.node.Node;

public class App {

    public static void main(String[] args) {
        int[] values = {5, 4, 7, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 23, 100, 45};
        BinaryTree tree = BinaryTree.create(values);
        Iterator iterator = tree.inOrderIterator();
        while (iterator.hasNext()) {
            System.out.println(((Node) iterator.next()).getValue());
        }
    }

}

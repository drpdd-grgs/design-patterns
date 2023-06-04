package behavioral.iterator;

import behavioral.iterator.node.BinaryTree;

public class App {

    public static void main(String[] args) {
        int[] values = {5, 4, 7, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 23, 100, 45};
        BinaryTree tree = BinaryTree.create(values);
        BinaryTree.Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }
    }

}

package behavioral.strategy;

import behavioral.strategy.sort.SortStrategy;
import behavioral.strategy.sort.Sorter;

public class App {

    public static void main(String[] args) {
        int[] arr = {5, 42, 2, 1, 0, 15};
        Sorter.sort(arr, SortStrategy.BUBBLE);
        int[] arr2 = {10, 0, 1, 3, 4, 2, 33};
        Sorter.sort(arr2, SortStrategy.QUICK);
        System.out.println();
    }

}

package factory;

import factory.sorter.SorterFactory;

public class App {
    public static void main(String[] args) {
        Integer[] testArray = {0, 1, 4, 6, 12, 2, 4, 3, 6};
        Integer[] sorted = (Integer[]) SorterFactory.getSorter(testArray, SorterFactory.SortMethod.QUICK).sort();
        for (Integer i : sorted) {
            System.out.println(i);
        }
    }
}

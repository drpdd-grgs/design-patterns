package behavioral.strategy.sort;

public class Sorter {

    public static void sort(int[] array, SortStrategy strategy) {
        ISortStrategy sortStrategy = null;
        switch (strategy) {
            case BUBBLE:
                sortStrategy = new BubbleSortStrategy();
                break;
            case QUICK:
                sortStrategy = new QuickSortStrategy();
                break;
        }
        sortStrategy.sort(array);
    }

}

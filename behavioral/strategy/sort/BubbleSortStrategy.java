package behavioral.strategy.sort;

public class BubbleSortStrategy implements ISortStrategy {

    @Override
    public void sort(int[] array) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    swapped = true;
                }
            }
        } while (swapped);
    }

}

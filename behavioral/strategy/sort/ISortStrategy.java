package behavioral.strategy.sort;

public interface ISortStrategy {

    void sort(int[] array);

    default void swap(int[] array, int left, int right) {
        if (left != right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

}

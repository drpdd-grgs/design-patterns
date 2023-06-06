package behavioral.strategy.sort;

public class QuickSortStrategy implements ISortStrategy {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pi = partition(arr, left, right);
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return (i + 1);
    }

}

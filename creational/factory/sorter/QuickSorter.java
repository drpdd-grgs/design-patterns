package creational.factory.sorter;

public class QuickSorter<T extends Comparable> extends AbstractSorter<T> {
    public QuickSorter(T[] toSort) {
        super(toSort);
    }

    @Override
    public T[] sort() {
        if (_length > 1) {
            quickSort(0, _length - 1);
        }
        return _toSort;
    }

    private void quickSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        T border = _toSort[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (_toSort[i].compareTo(border) == -1) {
                i++;
            }
            while (_toSort[j].compareTo(border) == 1) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(low, j);
        }
        if (high > i) {
            quickSort(i, high);
        }
    }
}
package creational.factory.sorter;

public class BubbleSorter<T extends Comparable> extends AbstractSorter<T> {
    public BubbleSorter(T[] toSort) {
        super(toSort);
    }

    @Override
    public T[] sort() {
        if (_length > 1) {
            for (int i = 0; i < _length - 1; i++) {
                for (int j = i + 1; j < _length; j++) {
                    if (_toSort[i].compareTo(_toSort[j]) == 1) {
                        swap(i, j);
                    }
                }
            }
        }
        return _toSort;
    }
}
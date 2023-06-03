package creational.factory.sorter;

public abstract class AbstractSorter<T extends Comparable> {
    protected T[] _toSort;
    protected final int _length;

    public AbstractSorter(T[] toSort) {
        _toSort = toSort;
        _length = toSort.length;
    }

    protected void swap(int i, int j) {
        T a = _toSort[i];
        _toSort[i] = _toSort[j];
        _toSort[j] = a;
    }

    abstract public T[] sort();
}

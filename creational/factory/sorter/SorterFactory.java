package creational.factory.sorter;

public class SorterFactory {
    public enum SortMethod {
        BUBBLE,
        QUICK
    }

    public static <T extends Comparable> AbstractSorter getSorter(T[] toSort, SortMethod sortMethod) {
        switch (sortMethod) {
            case BUBBLE:
                return new BubbleSorter(toSort);
            case QUICK:
                return new QuickSorter(toSort);
            default:
                throw new IllegalStateException("Unknown Sort Method: " + sortMethod.toString());
        }
    }
}

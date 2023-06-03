package creational.singleton;

public class LazySyncAccessor {
    // не инициализируется при запуске
    // низкая производительность

    private static LazySyncAccessor instance;

    private LazySyncAccessor() {

    }

    public static synchronized LazySyncAccessor getInstance() {
        if (instance == null) {
            instance = new LazySyncAccessor();
        }
        return instance;
    }
}

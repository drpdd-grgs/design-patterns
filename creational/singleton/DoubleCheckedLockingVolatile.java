package creational.singleton;

public class DoubleCheckedLockingVolatile {
    // не инициализируется при запуске
    // высокая производительность
    // volatile для случаев, когда иной поток при инициализации получает и использует не полностью сконструированный объект

    private static volatile DoubleCheckedLockingVolatile instance;

    private DoubleCheckedLockingVolatile() {

    }

    public static DoubleCheckedLockingVolatile getInstance() {
        DoubleCheckedLockingVolatile localInstance = instance;
        if (localInstance == null) {
            synchronized (DoubleCheckedLockingVolatile.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DoubleCheckedLockingVolatile();
                }
            }
        }
        return localInstance;
    }
}

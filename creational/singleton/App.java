package creational.singleton;

public class App {
    public static void main(String[] args) {
        NonLazySingleton nonLazySingleTon = NonLazySingleton.INSTANCE;
        LazySyncAccessor lazySyncAccessor = LazySyncAccessor.getInstance();
        DoubleCheckedLockingVolatile doubleCheckedLockingVolatile = DoubleCheckedLockingVolatile.getInstance();
        OnDemandHolderIdiom onDemandHolderIdiom = OnDemandHolderIdiom.getInstance();
    }
}

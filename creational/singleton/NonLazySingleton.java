package creational.singleton;

public class NonLazySingleton {
    // потокобезопасный
    // инициализируется при запуске

    public static final NonLazySingleton INSTANCE = new NonLazySingleton();

    private NonLazySingleton() {

    }
}

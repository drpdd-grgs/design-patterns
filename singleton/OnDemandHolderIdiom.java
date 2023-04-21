package singleton;

public class OnDemandHolderIdiom {
    // не инициализируется при запуске
    // высокая производительность
    // невозможно использовать для не статических полей класса

    public static class SingletonHolder {
        public static final OnDemandHolderIdiom HOLDER_INSTANCE = new OnDemandHolderIdiom();
    }

    public static OnDemandHolderIdiom getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private OnDemandHolderIdiom() {

    }
}

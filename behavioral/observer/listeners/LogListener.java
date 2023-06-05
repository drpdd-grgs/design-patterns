package behavioral.observer.listeners;

public class LogListener implements EventListener {

    @Override
    public void update(String eventType, String content) {
        System.out.println("LOG: " + content);
    }

}

package behavioral.observer.listeners;

public class SendListener implements EventListener {

    @Override
    public void update(String eventType, String content) {
        System.out.println("Event " + eventType + " is happened. Send message: " + content + " to external.");
    }

}

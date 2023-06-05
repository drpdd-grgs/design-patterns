package behavioral.observer.eventmanager;

import behavioral.observer.console.Console;
import behavioral.observer.listeners.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private final Map<String, List<EventListener>> eventListeners;

    public EventManager(String... eventTypes) {
        eventListeners = new HashMap<>();
        for (String eventType : eventTypes) {
            this.eventListeners.put(eventType, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> listeners = eventListeners.get(eventType);
        listeners.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> listeners = eventListeners.get(eventType);
        listeners.remove(listener);
    }

    public void notify(String eventType, String content) {
        List<EventListener> listeners = eventListeners.get(eventType);
        if (listeners == null) {
            listeners = eventListeners.get(Console.LOG_EVENT);
            content = "ERROR: unknown eventType.";
        }
        for (EventListener eventListener : listeners) {
            eventListener.update(eventType, content);
        }
    }

}

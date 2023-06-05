package behavioral.observer.console;

import behavioral.observer.eventmanager.EventManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    public static final String LOG_EVENT = "log";
    public static final String SEND_EVENT = "send";
    private static final String STOP = "stop";

    private final EventManager eventManager;

    public Console() {
        this.eventManager = new EventManager(LOG_EVENT, SEND_EVENT);
    }

    public void start() throws IOException {
        System.out.println("type " + LOG_EVENT + " for log, type " + SEND_EVENT + " for send, type " + STOP + " for stop.");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String input = "";

        while (true) {
            input = reader.readLine();
            if (input.equals(STOP)) {
                break;
            }
            Pair<String, String> eventTypeAndContent = parseEvent(input);
            String eventType = eventTypeAndContent.getFirst();
            String content = eventTypeAndContent.getSecond();

            eventManager.notify(eventType, content);
        }
        reader.close();
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    private Pair<String, String> parseEvent(String input) {
        StringBuilder eventType = new StringBuilder();
        StringBuilder content = new StringBuilder();
        if (input != null && input.length() > 0) {
            boolean eventParsed = false;
            for (char c : input.toCharArray()) {
                if (!eventParsed && c == ' ') {
                    eventParsed = true;
                    continue;
                }
                if (eventParsed) {
                    content.append(c);
                } else {
                    eventType.append(c);
                }

            }
        }
        return new Pair<>(eventType.toString(), content.toString());
    }

    private static class Pair<T, R> {

        private final T first;
        private final R second;

        private Pair(T first, R second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public R getSecond() {
            return second;
        }

    }

}

package behavioral.observer;

import behavioral.observer.console.Console;
import behavioral.observer.listeners.LogListener;
import behavioral.observer.listeners.SendListener;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Console console = new Console();
        console.getEventManager().subscribe(Console.LOG_EVENT, new LogListener());
        console.getEventManager().subscribe(Console.SEND_EVENT, new SendListener());
        console.start();
    }

}

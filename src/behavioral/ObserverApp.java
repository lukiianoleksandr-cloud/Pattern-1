package behavioral;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public interface EventListener {
        void update(String event);
    }

    public static class EventManager {
        private List<EventListener> listeners = new ArrayList<>();
        public void subscribe(EventListener listener) { listeners.add(listener); }
        public void notifyListeners(String event) {
            for (EventListener listener : listeners) listener.update(event);
        }
    }

    public static class LogListener implements EventListener {
        public void update(String event) {
            System.out.println("[Observer] Отримано сповіщення про подію: " + event);
        }
    }
}
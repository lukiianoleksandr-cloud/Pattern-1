package behavioral;

public class TemplateApp {
    public static abstract class Game {
        abstract void initialize();
        abstract void start();

        // Шаблонний метод
        public final void play() {
            initialize();
            start();
        }
    }

    public static class Football extends Game {
        void initialize() { System.out.println("[Template] Футбол: Ініціалізація параметрів матчу."); }
        void start() { System.out.println("[Template] Футбол: Матч розпочато!"); }
    }
}
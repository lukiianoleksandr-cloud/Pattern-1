package structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public interface Graphic { void move(int x, int y); }

    public static class Dot implements Graphic {
        private int x, y;
        public Dot(int x, int y) { this.x = x; this.y = y; }
        public void move(int x, int y) {
            this.x += x; this.y += y;
            System.out.println("  Крапка переміщена на: (" + this.x + "," + this.y + ")");
        }
    }

    public static class CompoundGraphic implements Graphic {
        private List<Graphic> children = new ArrayList<>();
        public void add(Graphic graphic) { children.add(graphic); }

        public void move(int x, int y) {
            System.out.println("[Composite] Переміщуємо всю групу графіки:");
            for (Graphic child : children) {
                child.move(x, y);
            }
        }
    }
}
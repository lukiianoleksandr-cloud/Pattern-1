package structural;

import java.util.HashMap;
import java.util.Map;

public class FlyweightApp {
    public static class TreeType {
        private String name, color;
        public TreeType(String name, String color) { this.name = name; this.color = color; }
        public void draw(int x, int y) {
            System.out.println("[Flyweight] Дерево '" + name + "' [" + color + "] відображено на (" + x + "," + y + ")");
        }
    }

    public static class TreeFactory {
        private static Map<String, TreeType> treeTypes = new HashMap<>();

        public static void plantTree(int x, int y, String name, String color) {
            String key = name + "_" + color;
            if (!treeTypes.containsKey(key)) {
                treeTypes.put(key, new TreeType(name, color));
            }
            treeTypes.get(key).draw(x, y);
        }
    }
}
package behavioral;
import java.util.ArrayList;
import java.util.List;

public class IteratorApp {
    public interface Iterator<T> {
        boolean hasNext();
        T next();
    }
    public interface Collection {
        Iterator<String> createIterator();
    }

    public static class NameCollection implements Collection {
        public List<String> names = new ArrayList<>();

        public Iterator<String> createIterator() {
            return new NameIterator();
        }

        private class NameIterator implements Iterator<String> {
            private int index = 0;
            public boolean hasNext() { return index < names.size(); }
            public String next() { return names.get(index++); }
        }
    }
}
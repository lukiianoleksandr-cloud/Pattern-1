package behavioral;

public class MementoApp {
    public static class Memento {
        private final String state;
        public Memento(String state) { this.state = state; }
        public String getState() { return state; }
    }

    public static class Editor {
        private String content;
        public void setContent(String content) { this.content = content; }
        public String getContent() { return content; }
        public Memento save() { return new Memento(content); }
        public void restore(Memento memento) { this.content = memento.getState(); }
    }
}
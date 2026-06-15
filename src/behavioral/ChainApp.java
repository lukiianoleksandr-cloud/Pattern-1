package behavioral;

public class ChainApp {
    public static abstract class Logger {
        protected Logger next;

        public void setNext(Logger next) {
            this.next = next;
        }

        public void log(String msg, int level) {
            if (canHandle(level)) {
                write(msg);
            }
            if (next != null) {
                next.log(msg, level);
            }
        }
        protected abstract boolean canHandle(int level);
        protected abstract void write(String msg);
    }

    public static class InfoLogger extends Logger {
        protected boolean canHandle(int level) { return level == 1; }
        protected void write(String msg) { System.out.println("[Chain] INFO: " + msg); }
    }

    public static class ErrorLogger extends Logger {
        protected boolean canHandle(int level) { return level == 2; }
        protected void write(String msg) { System.out.println("[Chain] ERROR: " + msg); }
    }
}
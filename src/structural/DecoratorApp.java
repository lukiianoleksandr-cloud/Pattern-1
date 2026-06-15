package structural;

public class DecoratorApp {
    public interface DataSource { void writeData(String data); }

    public static class BookDataSource implements DataSource {
        public void writeData(String data) { System.out.println("Запис у файл базових даних: " + data); }
    }

    public static class EncryptionDecorator implements DataSource {
        private DataSource wrappee;
        public EncryptionDecorator(DataSource source) { this.wrappee = source; }

        public void writeData(String data) {
            System.out.print("[Decorator] Обгортка зашифрувала дані -> ");
            wrappee.writeData(data.toUpperCase() + " (ENCRYPTED)");
        }
    }
}
package revisited;

import java.util.function.Consumer;

public class ExecuteAroundApp {
    public static class DatabaseConnection {
        private DatabaseConnection() {
            System.out.println("[Execute Around] 🟢 Підключення до БД відкрито.");
        }

        public void executeQuery(String sql) {
            System.out.println("[Execute Around] ⚡ Виконання запиту: " + sql);
        }

        private void close() {
            System.out.println("[Execute Around] 🔴 Підключення до БД автоматично закрито.");
        }

        public static void openAndExecute(Consumer<DatabaseConnection> block) {
            DatabaseConnection db = new DatabaseConnection();
            try {
                block.accept(db);
            } finally {
                db.close();
            }
        }
    }
}
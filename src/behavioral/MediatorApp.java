package behavioral;

public class MediatorApp {
    public static class ChatRoom {
        public static void showMessage(User user, String msg) {
            System.out.println("[Mediator] [" + user.getName() + "]: " + msg);
        }
    }

    public static class User {
        private String name;
        public User(String name) { this.name = name; }
        public String getName() { return name; }
        public void sendMessage(String msg) { ChatRoom.showMessage(this, msg); }
    }
}
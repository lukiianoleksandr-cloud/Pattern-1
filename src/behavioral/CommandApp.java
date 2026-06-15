package behavioral;

public class CommandApp {
    public interface Command {
        void execute();
    }

    public static class Light {
        public void turnOn() {
            System.out.println("[Command] Світло увімкнено.");
        }
    }

    public static class LightOnCommand implements Command {
        private Light light;
        public LightOnCommand(Light light) { this.light = light; }
        public void execute() { light.turnOn(); }
    }

    public static class RemoteControl {
        private Command command;
        public void setCommand(Command command) { this.command = command; }
        public void pressButton() { command.execute(); }
    }
}
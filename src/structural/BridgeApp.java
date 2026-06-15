package structural;

public class BridgeApp {
    public interface Device {
        boolean isEnabled();
        void enable();
        void disable();
    }

    public static class Radio implements Device {
        private boolean on = false;
        public boolean isEnabled() { return on; }
        public void enable() { on = true; }
        public void disable() { on = false; }
    }

    public static class RemoteControl {
        protected Device device;
        public RemoteControl(Device device) { this.device = device; }

        public void togglePower() {
            if (device.isEnabled()) {
                device.disable();
                System.out.println("[Bridge] Пристрій вимкнено через пульт.");
            } else {
                device.enable();
                System.out.println("[Bridge] Пристрій увімкнено через пульт.");
            }
        }
    }
}
package behavioral;

public class StateApp {
    public interface State {
        void doAction(Context context);
    }

    public static class PlayState implements State {
        public void doAction(Context context) {
            System.out.println("[State] Пристрій переведено в режим відтворення (PLAY).");
            context.setState(this);
        }
    }

    public static class Context {
        private State state;
        public void setState(State state) { this.state = state; }
        public State getState() { return state; }
    }
}
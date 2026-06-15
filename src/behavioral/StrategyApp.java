package behavioral;

public class StrategyApp {
    public interface Strategy {
        int execute(int a, int b);
    }

    public static class OperationAdd implements Strategy {
        public int execute(int a, int b) { return a + b; }
    }

    public static class Context {
        private Strategy strategy;
        public Context(Strategy strategy) { this.strategy = strategy; }
        public int executeStrategy(int a, int b) { return strategy.execute(a, b); }
    }
}
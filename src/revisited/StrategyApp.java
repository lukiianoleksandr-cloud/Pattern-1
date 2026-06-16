package revisited;

import java.util.function.BinaryOperator;

public class StrategyApp {
    public static class Order {
        public static int calculate(int price, int delivery, BinaryOperator<Integer> strategy) {
            return strategy.apply(price, delivery);
        }
    }
}
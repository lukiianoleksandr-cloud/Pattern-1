package revisited;

import java.util.function.UnaryOperator;

public class DecoratorApp {
    public static class TextProcessor {
        public static String translate(String text, UnaryOperator<String> decorator) {
            return decorator.apply(text);
        }
    }
}
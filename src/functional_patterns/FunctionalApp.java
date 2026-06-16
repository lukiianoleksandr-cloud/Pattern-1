package functional_patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalApp {

    public interface MathOperation {
        int compute(int a, int b);
    }

    public static int executeStrategy(int a, int b, MathOperation operation) {
        return operation.compute(a, b);
    }


    public interface Product {
        String getName();
    }

    public static class Phone implements Product {
        public String getName() { return "Смартфон"; }
    }

    public static class Laptop implements Product {
        public String getName() { return "Ноутбук"; }
    }

    public static class ProductFactory {
        private static final Map<String, Supplier<Product>> map = new HashMap<>();

        static {
            map.put("phone", Phone::new);
            map.put("laptop", Laptop::new);
        }

        public static Product createProduct(String type) {
            Supplier<Product> product = map.get(type.toLowerCase());
            if (product != null) return product.get();
            throw new IllegalArgumentException("Невідомий тип продукту");
        }
    }


    public static class TextProcessor {
        public static String process(String text, UnaryOperator<String> decorator) {
            return decorator.apply(text);
        }
    }


    public static class Resource {
        private Resource() { System.out.println("[Execute Around] Ресурс виділено / підключено."); }

        public void use() { System.out.println("[Execute Around] Робота з ресурсом..."); }

        private void close() { System.out.println("[Execute Around] Ресурс автоматично закрито / звільнено."); }

        public static void handle(Consumer<Resource> block) {
            Resource resource = new Resource();
            try {
                block.accept(resource);
            } finally {
                resource.close();
            }
        }
    }
}
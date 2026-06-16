package revisited;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryApp {
    public interface Vehicle {
        String drive();
    }

    public static class Bike implements Vehicle {
        public String drive() { return "[Factory] 🚲 Велосипед їде..."; }
    }

    public static class Car implements Vehicle {
        public String drive() { return "[Factory] 🚗 Автомобіль їде..."; }
    }

    public static class VehicleFactory {
        private static final Map<String, Supplier<Vehicle>> registeredTypes = new HashMap<>();

        static {
            registeredTypes.put("bike", Bike::new);
            registeredTypes.put("car", Car::new);
        }

        public static Vehicle create(String type) {
            Supplier<Vehicle> vehicle = registeredTypes.get(type.toLowerCase());
            if (vehicle == null) throw new IllegalArgumentException("Unknown vehicle type");
            return vehicle.get();
        }
    }
}
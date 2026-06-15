package creational;

public class Patterns {

    // 1. Singleton
    public static class Singleton {
        private static Singleton instance;
        private Singleton() {}
        public static Singleton getInstance() {
            if (instance == null) instance = new Singleton();
            return instance;
        }
        public void show() { System.out.println("[Singleton] Працює."); }
    }

    // 2. Simple Factory
    public interface ISimpleProduct { void use(); }
    public static class ConcreteProductX implements ISimpleProduct {
        public void use() { System.out.println("[Simple Factory] Використовуємо продукт X."); }
    }
    public static class SimpleFactory {
        public static ISimpleProduct createProduct(String type) { return new ConcreteProductX(); }
    }

    // 3. Factory Method
    public interface IProduct { void play(); }
    public static class ConcreteProductA implements IProduct {
        public void play() { System.out.println("[Factory Method] Продукт А."); }
    }
    public static abstract class Creator {
        public abstract IProduct factoryMethod();
        public void action() { factoryMethod().play(); }
    }
    public static class ConcreteCreatorA extends Creator {
        public IProduct factoryMethod() { return new ConcreteProductA(); }
    }

    // 4. Abstract Factory
    public interface IChair { String sitOn(); }
    public interface ISofa { String relaxOn(); }
    public static class ModernChair implements IChair { public String sitOn() { return "Модерн Стілець"; } }
    public static class ModernSofa implements ISofa { public String relaxOn() { return "Модерн Диван"; } }
    public interface IFurnitureFactory { IChair createChair(); ISofa createSofa(); }
    public static class ModernFurnitureFactory implements IFurnitureFactory {
        public IChair createChair() { return new ModernChair(); }
        public ISofa createSofa() { return new ModernSofa(); }
    }

    // 5. Builder
    public static class Pizza { public int size; public boolean cheese; public boolean bacon; }
    public static abstract class PizzaBuilder {
        protected Pizza pizza = new Pizza();
        public Pizza getPizza() { return pizza; }
        public abstract void setSize();
        public abstract void addCheese();
        public abstract void addBacon();
    }
    public static class MeatPizzaBuilder extends PizzaBuilder {
        public void setSize() { pizza.size = 30; }
        public void addCheese() { pizza.cheese = true; }
        public void addBacon() { pizza.bacon = true; }
    }

    // 6. Prototype
    public interface Prototype { Prototype clonePrototype(); }
    public static class Sheep implements Prototype {
        public String name;
        public Sheep(String name) { this.name = name; }
        public Prototype clonePrototype() { return new Sheep(this.name); }
    }
}
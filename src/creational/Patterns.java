package creational;

public class Patterns {


    public static class Singleton {
        private static Singleton instance;
        private Singleton() {}
        public static Singleton getInstance() {
            if (instance == null) instance = new Singleton();
            return instance;
        }
        public void show() { System.out.println("[Singleton] Працює єдиний екземпляр."); }
    }


    public interface ISimpleProduct { void use(); }
    public static class ProductX implements ISimpleProduct { public void use() { System.out.println("[Simple Factory] Використовуємо Product X"); } }
    public static class ProductY implements ISimpleProduct { public void use() { System.out.println("[Simple Factory] Використовуємо Product Y"); } }

    public static class SimpleFactory {
        public static ISimpleProduct createProduct(String type) {
            if (type.equalsIgnoreCase("X")) return new ProductX();
            else return new ProductY();
        }
    }

    public interface IProduct { String getName(); }
    public static class ConcreteProductA implements IProduct { public String getName() { return "Product A"; } }

    public static abstract class Creator {
        public abstract IProduct factoryMethod();
        public void action() { System.out.println("[Factory Method] Створено: " + factoryMethod().getName()); }
    }
    public static class ConcreteCreatorA extends Creator { public IProduct factoryMethod() { return new ConcreteProductA(); } }


    public interface IChair { String sitOn(); }
    public interface ISofa { String relaxOn(); }
    public static class ModernChair implements IChair { public String sitOn() { return "Сучасне крісло"; } }
    public static class ModernSofa implements ISofa { public String relaxOn() { return "Сучасний диван"; } }

    public interface IFurnitureFactory {
        IChair createChair();
        ISofa createSofa();
    }
    public static class ModernFurnitureFactory implements IFurnitureFactory {
        public IChair createChair() { return new ModernChair(); }
        public ISofa createSofa() { return new ModernSofa(); }
    }


    public static class Pizza { public String size; public boolean cheese; public boolean bacon; }
    public interface IPizzaBuilder {
        void setSize();
        void addCheese();
        void addBacon();
        Pizza getPizza();
    }
    public static class MeatPizzaBuilder implements IPizzaBuilder {
        private Pizza pizza = new Pizza();
        public void setSize() { pizza.size = "Велика"; }
        public void addCheese() { pizza.cheese = true; }
        public void addBacon() { pizza.bacon = true; }
        public Pizza getPizza() { return pizza; }
    }

    public interface IPrototype { IPrototype clonePrototype(); }
    public static class Sheep implements IPrototype {
        public String name;
        public Sheep(String name) { this.name = name; }
        public IPrototype clonePrototype() { return new Sheep(this.name); }
    }
}
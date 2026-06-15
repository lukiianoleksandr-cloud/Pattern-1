package creational;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
    public void show() { System.out.println("[Singleton] Працює єдиний екземпляр."); }
}


interface IProduct { String getName(); }
class ConcreteProductA implements IProduct { public String getName() { return "Product A"; } }

abstract class Creator {
    public abstract IProduct factoryMethod();
    public void action() { System.out.println("[Factory Method] Створено: " + factoryMethod().getName()); }
}
class ConcreteCreatorA extends Creator { public IProduct factoryMethod() { return new ConcreteProductA(); } }


interface IChair { String sitOn(); }
interface ISofa { String relaxOn(); }
class ModernChair implements IChair { public String sitOn() { return "Сучасне крісло"; } }
class ModernSofa implements ISofa { public String relaxOn() { return "Сучасний диван"; } }

interface IFurnitureFactory {
    IChair createChair();
    ISofa createSofa();
}
class ModernFurnitureFactory implements IFurnitureFactory {
    public IChair createChair() { return new ModernChair(); }
    public ISofa createSofa() { return new ModernSofa(); }
}


class Pizza { public String size; public boolean cheese; public boolean bacon; }
interface IPizzaBuilder {
    void setSize();
    void addCheese();
    void addBacon();
    Pizza getPizza();
}
class MeatPizzaBuilder implements IPizzaBuilder {
    private Pizza pizza = new Pizza();
    public void setSize() { pizza.size = "Велика"; }
    public void addCheese() { pizza.cheese = true; }
    public void addBacon() { pizza.bacon = true; }
    public Pizza getPizza() { return pizza; }
}


interface IPrototype { IPrototype clonePrototype(); }
class Sheep implements IPrototype {
    public String name;
    public Sheep(String name) { this.name = name; }
    public IPrototype clonePrototype() { return new Sheep(this.name); }
}

class PooledObject { public int id = new Random().nextInt(100, 999); }
class ObjectPool {
    private List<PooledObject> available = new ArrayList<>();
    public PooledObject getObject() {
        if (available.isEmpty()) return new PooledObject();
        return available.remove(0);
    }
    public void releaseObject(PooledObject obj) { available.add(obj); }
}

public class Patterns {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ПОРОДЖУВАЛЬНИХ ПАТЕРНІВ ===\n");

        Singleton.getInstance().show();

        Creator creator = new ConcreteCreatorA();
        creator.action();

        IFurnitureFactory factory = new ModernFurnitureFactory();
        System.out.println("[Abstract Factory] Набір: " + factory.createChair().sitOn() + " та " + factory.createSofa().relaxOn());

        MeatPizzaBuilder builder = new MeatPizzaBuilder();
        builder.setSize(); builder.addCheese(); builder.addBacon();
        Pizza pizza = builder.getPizza();
        System.out.println("[Builder] Піца: Розмір=" + pizza.size + ", Сир=" + pizza.cheese + ", Бекон=" + pizza.bacon);

        Sheep original = new Sheep("Доллі");
        Sheep clone = (Sheep) original.clonePrototype();
        System.out.println("[Prototype] Оригінал: " + original.name + ", Клон: " + clone.name);

        ObjectPool pool = new ObjectPool();
        PooledObject obj1 = pool.getObject();
        System.out.println("[Object Pool] Взято об'єкт з ID: " + obj1.id);
        pool.releaseObject(obj1);

        System.out.println("\nВсі патерни успішно відпрацювали!");
    }
}
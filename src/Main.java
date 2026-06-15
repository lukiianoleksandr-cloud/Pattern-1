import creational.Patterns;
import structural.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ПОРОДЖУВАЛЬНИХ ПАТЕРНІВ (Лаба 1) ===\n");
        Patterns.Singleton.getInstance().show();
        Patterns.ISimpleProduct prod = Patterns.SimpleFactory.createProduct("X");
        prod.use();
        Patterns.Creator creator = new Patterns.ConcreteCreatorA();
        creator.action();
        Patterns.IFurnitureFactory factory = new Patterns.ModernFurnitureFactory();
        System.out.println("[Abstract Factory] Набір: " + factory.createChair().sitOn() + " та " + factory.createSofa().relaxOn());
        Patterns.MeatPizzaBuilder builder = new Patterns.MeatPizzaBuilder();
        builder.setSize(); builder.addCheese(); builder.addBacon();
        Patterns.Pizza pizza = builder.getPizza();
        System.out.println("[Builder] Піца: Розмір=" + pizza.size + ", Сир=" + pizza.cheese + ", Бекон=" + pizza.bacon);
        Patterns.Sheep original = new Patterns.Sheep("Доллі");
        Patterns.Sheep clone = (Patterns.Sheep) original.clonePrototype();
        System.out.println("[Prototype] Оригінал: " + original.name + ", Клон: " + clone.name);

        System.out.println("\n=== ДЕМОНСТРАЦІЯ СТРУКТУРНИХ ПАТЕРНІВ (Лаба 3 - Фінал) ===\n");

        // 1. Adapter
        AdapterApp.SquarePeg squarePeg = new AdapterApp.SquarePeg(10.0);
        AdapterApp.SquarePegAdapter adapter = new AdapterApp.SquarePegAdapter(squarePeg);
        System.out.println("[Adapter] Адаптований радіус квадратного кілка: " + adapter.getRadius());

        // 2. Bridge
        BridgeApp.Device radio = new BridgeApp.Radio();
        BridgeApp.RemoteControl remote = new BridgeApp.RemoteControl(radio);
        remote.togglePower();

        // 3. Composite
        CompositeApp.CompoundGraphic group = new CompositeApp.CompoundGraphic();
        group.add(new CompositeApp.Dot(1, 2));
        group.add(new CompositeApp.Dot(10, 20));
        group.move(5, 5);

        // 4. Decorator
        DecoratorApp.DataSource source = new DecoratorApp.BookDataSource();
        DecoratorApp.DataSource decorator = new DecoratorApp.EncryptionDecorator(source);
        decorator.writeData("Hello World");

        // 5. Facade
        FacadeApp.VideoConverter converter = new FacadeApp.VideoConverter();
        converter.convertVideo("holiday_video.avi");

        // 6. Flyweight
        FlyweightApp.TreeFactory.plantTree(10, 20, "Дуб", "Зелений");
        FlyweightApp.TreeFactory.plantTree(15, 25, "Дуб", "Зелений");

        // 7. Proxy
        ProxyApp.YouTubeCacheProxy youtubeProxy = new ProxyApp.YouTubeCacheProxy();
        youtubeProxy.renderVideoPage("cat_video");
        youtubeProxy.renderVideoPage("cat_video");

        System.out.println("\nВсі структурні патерни успішно відпрацювали!");
    }
}
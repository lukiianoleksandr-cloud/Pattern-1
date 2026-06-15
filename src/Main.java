import creational.Patterns;
import structural.*;
import behavioral.*;

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

        System.out.println("\n=== ДЕМОНСТРАЦІЯ СТРУКТУРНИХ ПАТЕРНІВ (Лаба 3) ===\n");
        AdapterApp.SquarePeg squarePeg = new AdapterApp.SquarePeg(10.0);
        AdapterApp.SquarePegAdapter adapter = new AdapterApp.SquarePegAdapter(squarePeg);
        System.out.println("[Adapter] Адаптований радіус квадратного кілка: " + adapter.getRadius());
        BridgeApp.Device radio = new BridgeApp.Radio();
        BridgeApp.RemoteControl remote = new BridgeApp.RemoteControl(radio);
        remote.togglePower();
        CompositeApp.CompoundGraphic group = new CompositeApp.CompoundGraphic();
        group.add(new CompositeApp.Dot(1, 2));
        group.move(5, 5);
        DecoratorApp.DataSource source = new DecoratorApp.BookDataSource();
        DecoratorApp.DataSource decorator = new DecoratorApp.EncryptionDecorator(source);
        decorator.writeData("Hello World");
        FacadeApp.VideoConverter converter = new FacadeApp.VideoConverter();
        converter.convertVideo("holiday_video.avi");
        FlyweightApp.TreeFactory.plantTree(10, 20, "Дуб", "Зелений");
        ProxyApp.YouTubeCacheProxy youtubeProxy = new ProxyApp.YouTubeCacheProxy();
        youtubeProxy.renderVideoPage("cat_video");

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ПОВЕДІНКОВИХ ПАТЕРНІВ (Лаба 4) ===\n");

        // 1. Chain of Responsibility
        ChainApp.Logger infoLog = new ChainApp.InfoLogger();
        ChainApp.Logger errorLog = new ChainApp.ErrorLogger();
        infoLog.setNext(errorLog);
        infoLog.log("Система працює стабільно.", 1);
        infoLog.log("Критичний збій бази даних!", 2);

        // 2. Command
        CommandApp.Light livingRoomLight = new CommandApp.Light();
        CommandApp.Command lightOn = new CommandApp.LightOnCommand(livingRoomLight);
        CommandApp.RemoteControl remoteControl = new CommandApp.RemoteControl();
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        // 3. Iterator
        IteratorApp.NameCollection nameCollection = new IteratorApp.NameCollection();
        nameCollection.names.add("Олександр");
        nameCollection.names.add("Марія");
        IteratorApp.Iterator<String> iter = nameCollection.createIterator();
        System.out.print("[Iterator] Елементи колекції: ");
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        // 4. Mediator
        MediatorApp.User user1 = new MediatorApp.User("Іван");
        MediatorApp.User user2 = new MediatorApp.User("Олена");
        user1.sendMessage("Привіт всім!");
        user2.sendMessage("Привіт, Іване!");

        // 5. Memento
        MementoApp.Editor editor = new MementoApp.Editor();
        editor.setContent("Версія #1");
        MementoApp.Memento savedState = editor.save();
        editor.setContent("Версія #2");
        System.out.println("[Memento] Поточний текст: " + editor.getContent());
        editor.restore(savedState);
        System.out.println("[Memento] Відновлений текст: " + editor.getContent());

        // 6. Observer
        ObserverApp.EventManager eventManager = new ObserverApp.EventManager();
        ObserverApp.LogListener listener = new ObserverApp.LogListener();
        eventManager.subscribe(listener);
        eventManager.notifyListeners("USER_LOGIN");

        // 7. State
        StateApp.Context stateContext = new StateApp.Context();
        StateApp.PlayState playState = new StateApp.PlayState();
        playState.doAction(stateContext);

        // 8. Strategy
        StrategyApp.Context strategyContext = new StrategyApp.Context(new StrategyApp.OperationAdd());
        System.out.println("[Strategy] Результат додавання (10 + 5): " + strategyContext.executeStrategy(10, 5));

        // 9. Template Method
        TemplateApp.Game game = new TemplateApp.Football();
        game.play();

        // 10. Visitor
        VisitorApp.Element computer = new VisitorApp.Computer();
        computer.accept(new VisitorApp.ComputerDisplayVisitor());

        System.out.println("\nВсі 10 поведінкових патернів успішно відпрацювали!");
    }
}
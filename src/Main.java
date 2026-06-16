import creational.Patterns;
import structural.*;
import behavioral.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

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

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ЛЯМБДА ВИРАЗІВ ТА STREAM API (Лаба 5) ===\n");
        List<Integer> intList = Arrays.asList(4, 7, 1, 8, 2, 9, 8, 5, 6);
        List<Double> doubleList = Arrays.asList(2.5, 4.0, 1.5, 8.0);
        List<String> stringList = Arrays.asList("Яблуко", "Банан", "Груша", "", "Апельсин", "ківі");

        System.out.println("1. Непарні числа зі списку: " + lambda.LambdaApp.filterOddNumbers(intList));
        System.out.println("2. Середнє значення дійсних чисел: " + lambda.LambdaApp.findAverage(doubleList));
        System.out.println("3. Сортування за алфавітом: " + lambda.LambdaApp.sortAlphabetically(Arrays.asList("Черешня", "Ананас", "Слива")));
        System.out.println("4. Сума всіх парних чисел списку: " + lambda.LambdaApp.sumOfEvenNumbers(intList));
        System.out.println("5. Факторіал числа 5: " + lambda.LambdaApp.calculateFactorial(5));
        System.out.println("6. Результати дій для (1, 2, 3, 4): " + lambda.LambdaApp.multiplyAndSum(Arrays.asList(1, 2, 3, 4)));
        System.out.println("7. Квадрати чисел списку: " + lambda.LambdaApp.squareNumbers(Arrays.asList(1, 2, 3, 5)));
        System.out.println("8. Сортування за довжиною: " + lambda.LambdaApp.sortByLength(Arrays.asList("ДовгийРядок", "Кіт", "Привіт")));
        System.out.println("9. Кількість слів у реченні: " + lambda.LambdaApp.countWords("Лямбда вирази це дуже зручно"));
        System.out.println("10. Перший непорожній рядок: " + lambda.LambdaApp.findFirstNonEmpty(stringList).orElse("Не знайдено"));
        System.out.println("11. Чи всі починаються з великої літери: " + lambda.LambdaApp.checkAllCapitalized(Arrays.asList("Київ", "Львів", "Одеса")));
        System.out.println("12. Друге за величиною число: " + lambda.LambdaApp.findSecondLargest(intList).orElse(-1));
        System.out.println("13. Найбільше парне число: " + lambda.LambdaApp.findLargestEven(intList).orElse(-1));
        System.out.println("\nВсі завдання Лабораторної роботи №5 успішно виконано!");


        System.out.println("\n=== ДЕМОНСТРАЦІЯ СУЧАСНИХ ФУНКЦІОНАЛЬНИХ ПАТЕРНІВ (Лаба 6) ===\n");

        // 1. Сучасна Стратегія через лямбди
        int regularPrice = revisited.StrategyApp.Order.calculate(100, 20, (p, d) -> p + d);
        int discountPrice = revisited.StrategyApp.Order.calculate(100, 20, (p, d) -> (int)(p * 0.9) + d);
        System.out.println("[Strategy] Звичайна ціна (ціна + доставка): " + regularPrice);
        System.out.println("[Strategy] Ціна зі знижкою 10%: " + discountPrice);

        // 2. Сучасна Фабрика через посилання на конструктор
        revisited.FactoryApp.Vehicle myBike = revisited.FactoryApp.VehicleFactory.create("bike");
        revisited.FactoryApp.Vehicle myCar = revisited.FactoryApp.VehicleFactory.create("car");
        System.out.println(myBike.drive());
        System.out.println(myCar.drive());

        // 3. Сучасний Декоратор через явні лямбда-вирази
        UnaryOperator<String> cleanText = s -> s.trim();
        UnaryOperator<String> upperText = s -> s.toUpperCase();
        UnaryOperator<String> pipeline = s -> upperText.apply(cleanText.apply(s));

        String resultText = revisited.DecoratorApp.TextProcessor.translate("    модернізований патерн    ", pipeline);
        System.out.println("[Decorator] Оброблений text: '" + resultText + "'");

        // 4. Патерн Навколишнє виконання (Execute Around)
        revisited.ExecuteAroundApp.DatabaseConnection.openAndExecute(db -> {
            db.executeQuery("SELECT * FROM users");
            db.executeQuery("UPDATE stats SET points = 100 WHERE id = 1");
        });

        System.out.println("\nВсі завдання Лабораторної роботи №6 успішно виконано за прикладом!");
    }
}
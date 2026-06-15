import creational.Patterns;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ПОРОДЖУВАЛЬНИХ ПАТЕРНІВ (Кафедральний стандарт) ===\n");

        // 1. Singleton
        Patterns.Singleton.getInstance().show();

        // 2. Factory (Проста фабрика)
        Patterns.ISimpleProduct prod = Patterns.SimpleFactory.createProduct("X");
        prod.use();

        // 3. Factory Method
        Patterns.Creator creator = new Patterns.ConcreteCreatorA();
        creator.action();

        // 4. Abstract Factory
        Patterns.IFurnitureFactory factory = new Patterns.ModernFurnitureFactory();
        System.out.println("[Abstract Factory] Набір: " + factory.createChair().sitOn() + " та " + factory.createSofa().relaxOn());

        // 5. Builder
        Patterns.MeatPizzaBuilder builder = new Patterns.MeatPizzaBuilder();
        builder.setSize(); builder.addCheese(); builder.addBacon();
        Patterns.Pizza pizza = builder.getPizza();
        System.out.println("[Builder] Піца: Розмір=" + pizza.size + ", Сир=" + pizza.cheese + ", Бекон=" + pizza.bacon);

        // 6. Prototype
        Patterns.Sheep original = new Patterns.Sheep("Доллі");
        Patterns.Sheep clone = (Patterns.Sheep) original.clonePrototype();
        System.out.println("[Prototype] Оригінал: " + original.name + ", Клон: " + clone.name);

        System.out.println("\nВсі 6 патернів за методичкою успішно відпрацювали!");
    }
}
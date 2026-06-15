package behavioral;

public class VisitorApp {
    public interface Element {
        void accept(Visitor visitor);
    }
    public interface Visitor {
        void visit(Computer computer);
    }

    public static class Computer implements Element {
        public void accept(Visitor visitor) { visitor.visit(this); }
    }

    public static class ComputerDisplayVisitor implements Visitor {
        public void visit(Computer computer) {
            System.out.println("[Visitor] Проводжу повну діагностику систем комп'ютера.");
        }
    }
}
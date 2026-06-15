package structural;

public class AdapterApp {
    public static class SquarePeg {
        private double width;
        public SquarePeg(double width) { this.width = width; }
        public double getWidth() { return width; }
    }

    public static class RoundPeg {
        private double radius;
        public RoundPeg() {}
        public RoundPeg(double radius) { this.radius = radius; }
        public double getRadius() { return radius; }
    }

    public static class SquarePegAdapter extends RoundPeg {
        private SquarePeg peg;
        public SquarePegAdapter(SquarePeg peg) { this.peg = peg; }

        @Override
        public double getRadius() {
            return (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        }
    }
}
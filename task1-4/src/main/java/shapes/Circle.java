package shapes;

public class Circle extends Shape {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    double calcArea() {
        return Math.PI * radius * radius;
    }

}

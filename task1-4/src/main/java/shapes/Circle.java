package shapes;

public class Circle {

    private int radius;

    public Circle(int side) {
        this.radius = side;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double area(int radius) {
        return Math.PI * radius * radius;
    }

}

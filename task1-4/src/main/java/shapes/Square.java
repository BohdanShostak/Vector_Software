package shapes;

public class Square extends Shape {
    int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    double calcArea() {
        return side * side;
    }

}

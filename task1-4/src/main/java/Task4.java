import shapes.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Sorting shapes ascending on area size
 */
public class Task4 {
    int side = 3;
    int radius = 1;
    int base = 5;
    int width = 2;
    int height = 2;
    List<Shape> shapes = new ArrayList<>();

    public void sortedShapesExample() {
        shapes.add(new Square(side));
        shapes.add(new Circle(radius));
        shapes.add(new Triangle(base, height));
        shapes.add(new Rectangle(width, height));

        System.out.println("Unsorted shapes:");
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getName());
        }

        AreaComparator areaComparator = new AreaComparator();
        shapes.sort(areaComparator);
        System.out.println("Sorted shapes:");

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getName());
        }
    }

}

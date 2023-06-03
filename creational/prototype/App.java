package creational.prototype;

import creational.prototype.shapes.Circle;
import creational.prototype.shapes.Rectangle;
import creational.prototype.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle._x = 10;
        circle._y = 15;
        circle._radius = 10;
        circle._color = "red";
        shapes.add(circle);

        Circle circleCopy = (Circle) circle.clone();
        shapes.add(circleCopy);

        Rectangle rectangle = new Rectangle();
        rectangle._width = 30;
        rectangle._height = 20;
        rectangle._color = "green";
        rectangle._x = 0;
        rectangle._y = 10;
        shapes.add(rectangle);

        Rectangle rectangleCopy = (Rectangle) rectangle.clone();
        shapes.add(rectangleCopy);

        for (Shape shape : shapes) {
            shapesCopy.add(shape);
        }

        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(i);
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println("Objects are different");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println("Objects identical");
                } else {
                    System.out.println("Objects not identical");
                }
            } else {
                System.out.println("Objects are same");
            }
        }
    }
}

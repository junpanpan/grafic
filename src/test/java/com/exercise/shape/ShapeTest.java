package com.exercise.shape;

import com.exercise.math.Position;
import com.exercise.shape.shapes.Circle;
import com.exercise.shape.shapes.Rectangle;
import com.exercise.shape.shapes.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShapeTest {

    @Test
    void testShapeIsComparableByArea() {
        List<Shape> shapes = new ArrayList<>();
        double x = 0.0;
        double y = 0.0;
        Circle circle = new Circle(new Position(x, y), 64.0);
        Square square = new Square(new Position(x, y), 32.0);
        Rectangle rectangle = new Rectangle(new Position(10.0, 0.0), 20.0, 10.0);

        shapes.add(circle);
        shapes.add(square);
        shapes.add(rectangle);

        Collections.sort(shapes);

        assertTrue(rectangle == shapes.get(0));
        assertTrue(square == shapes.get(1));
        assertTrue(circle == shapes.get(2));
    }

}

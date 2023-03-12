package com.exercise.shape;

import com.exercise.math.Position;
import com.exercise.shape.shapes.Circle;
import com.exercise.shape.shapes.Rectangle;
import com.exercise.shape.shapes.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShapeUtilsTest {

    @Test
    void testGenerateRandomShapes() {
        double positionMax = 10.0;
        double sizeMax = 20.0;
        ArrayList<Shape> shapes = ShapeUtils.generateRandomShapes(14, positionMax, sizeMax);
        assertEquals(14, shapes.size());

        for (Shape shape : shapes) {
            assertTrue(shape.getPosition().getX() <= positionMax);
            assertTrue(shape.getPosition().getY() <= positionMax);
        }
    }

    @DisplayName("two positions are too close, should remove one.")
    @Test
    void testRemoveCloseByShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        double x = 0.0;
        double y = 0.0;
        shapes.add(new Circle(new Position(x, y), 64.0));
        shapes.add(new Square(new Position(x, y), 32.0));
        shapes.add(new Rectangle(new Position(10.0, 0.0), 20.0, 10.0));

        ShapeUtils.removeCloseByShapes(shapes, 1);
        assertEquals(2, shapes.size());
    }

    @DisplayName("three positions are too close, should remove 2.")
    @Test
    void testRemoveCloseByShapes_2() {
        ArrayList<Shape> shapes = new ArrayList<>();
        double x = 0.0;
        double y = 0.0;
        shapes.add(new Circle(new Position(x, y), 64.0));
        shapes.add(new Square(new Position(x, y), 32.0));
        shapes.add(new Rectangle(new Position(x, y), 20.0, 10.0));

        ShapeUtils.removeCloseByShapes(shapes, 1.0);
        assertEquals(1, shapes.size());
    }

    @DisplayName("No positions are too close, should remove nothing.")
    @Test
    void testRemoveCloseByShapes_3() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(new Position(0, 0), 64.0));
        shapes.add(new Square(new Position(5, 5), 32.0));
        shapes.add(new Rectangle(new Position(10.0, 0.0), 20.0, 10.0));

        ShapeUtils.removeCloseByShapes(shapes, 1);
        assertEquals(3, shapes.size());
    }

    @Test
    void testDoc() throws Exception {
        Document document = ShapeUtils.createXML(new ArrayList<>());
    }
}
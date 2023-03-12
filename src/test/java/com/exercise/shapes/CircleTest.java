package com.exercise.shapes;

import com.exercise.math.Position;
import com.exercise.shape.InvalidSizeException;
import com.exercise.shape.shapes.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void testCalculateArea() {

        double radius = 64.0;
        Circle circle = new Circle(new Position(0.0, 0.0), radius);

        double expected = radius * radius * Math.PI;

        assertEquals(expected, circle.calculateArea());

        radius = 37079.3;
        circle = new Circle(new Position(100.0, 432.0), radius);
        expected = radius * radius * Math.PI;
        assertEquals(expected, circle.calculateArea());
    }

    @Test
    void testInvalid() {
        try {
            new Circle(new Position(0.0, 0.0), -1.0);
            fail("should fail to create.");
        } catch (InvalidSizeException ex) {
            assertTrue(true);
        }
    }
}
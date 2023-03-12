package com.exercise.shapes;

import com.exercise.math.Position;
import com.exercise.shape.InvalidSizeException;
import com.exercise.shape.shapes.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testCalculateArea() throws InvalidSizeException {
        double x = 100.0;
        double y = 20.0;
        double expected = x * y / 2;
        Triangle triangle = new Triangle(new Position(0.0, 0.0), x, y);
        assertEquals(expected, triangle.calculateArea());

        x = 200.0;
        y = 37079.3;
        expected = x * y / 2;
        triangle = new Triangle(new Position(100.0, 432.0), x, y);
        assertEquals(expected, triangle.calculateArea());
    }

    @Test
    void testInvalid_X() {
        try {
            new Triangle(new Position(0.0, 0.0), -1.0, 2.0);
            fail("should fail to create.");
        } catch (InvalidSizeException ex) {
            assertTrue(true);
        }
    }

    @Test
    void testInvalid_Y() {
        try {
            new Triangle(new Position(0.0, 0.0), 1.0, -2.0);
            fail("should fail to create.");
        } catch (InvalidSizeException ex) {
            assertTrue(true);
        }
    }
}
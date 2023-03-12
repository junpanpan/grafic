package com.exercise.shapes;

import com.exercise.math.Position;
import com.exercise.shape.InvalidSizeException;
import com.exercise.shape.shapes.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testCalculateArea() {
        double x = 100.0;
        double y = 20.0;
        Rectangle rectangle = new Rectangle(new Position(0.0, 0.0), x, y);
        double expected = x * y;
        assertEquals(expected, rectangle.calculateArea());


        x = 200.0;
        y = 37079.3;
        expected = x * y;
        rectangle = new Rectangle(new Position(100.0, 432.0), x, y);
        assertEquals(expected, rectangle.calculateArea());
    }

    @Test
    void testInvalid_X() {
        try {
            new Rectangle(new Position(0.0, 0.0), -1.0, 10);
            fail("should fail to create.");
        } catch (InvalidSizeException ex) {
            assertTrue(true);
        }
    }

    @Test
    void testInvalid_Y() {
        try {
            new Rectangle(new Position(0.0, 0.0), 1.0, -10);
            fail("should fail to create.");
        } catch (InvalidSizeException ex) {
            assertTrue(true);
        }
    }
}
package com.exercise.shapes;

import com.exercise.math.Position;
import com.exercise.shape.InvalidSizeException;
import com.exercise.shape.shapes.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testCalculateArea() throws InvalidSizeException {
        double x = 100.0;
        double expected = Math.pow(x, 2);
        Square square = new Square(new Position(0.0, 0.0), x);
        assertEquals(expected, square.calculateArea());

        x = 3707.3;
        expected = Math.pow(x, 2);
        square = new Square(new Position(100.0, 432.0), x);
        assertEquals(expected, square.calculateArea());
    }

    @Test
    void testInvalid() {
        try {
            new Square(new Position(0.0, 0.0), -1.0);
            fail("should fail to create.");
        } catch (InvalidSizeException ex) {
            assertTrue(true);
        }
    }
}
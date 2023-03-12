package com.exercise.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testDistance() {
        Position position = new Position(0.0, 0.0);
        Position otherPosition = new Position(1.0, 2.0);

        double xDistanceSquared = Math.pow(position.getX() - otherPosition.getX(), 2.0);
        double yDistanceSquared = Math.pow(position.getY() - otherPosition.getY(), 2.0);
        double expected = Math.sqrt(xDistanceSquared + yDistanceSquared);

        assertTrue(Double.compare(expected, position.distance(otherPosition)) == 0);

        position = new Position(-30, 0);
        otherPosition = new Position(1, 3000);

        xDistanceSquared = Math.pow(position.getX() - otherPosition.getX(), 2.0);
        yDistanceSquared = Math.pow(position.getY() - otherPosition.getY(), 2.0);
        expected = Math.sqrt(xDistanceSquared + yDistanceSquared);

        assertTrue(Double.compare(expected, position.distance(otherPosition)) == 0);
    }

    @Test
    void testShouldEquals() {
        Position position = new Position(389.0, -799.7897);
        Position otherPosition = new Position(389.0, -799.7897);
        assertEquals(position, otherPosition);
    }

    @Test
    void testNotEquals() {
        Position position = new Position(389.0, 799.7897);
        Position otherPosition = new Position(-4342.0, 39.789);
        assertNotEquals(position, otherPosition);
    }
}
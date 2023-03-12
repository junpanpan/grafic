package com.exercise.math;

import java.util.Objects;

public final class Position {
    private final double x;
    private final double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Returns the distance between this Position and the other Position
     *
     * @param other another Position to check distance from
     * @return the distance to the other Position
     */
    public double distance(Position other) {
        Objects.nonNull(other);

        double xDistanceSquared = Math.pow(x - other.x, 2.0);
        double yDistanceSquared = Math.pow(y - other.y, 2.0);
        return Math.sqrt(xDistanceSquared + yDistanceSquared);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o instanceof Position) {
            Position position2 = (Position) o;
            return Double.compare(position2.x, x) == 0 && Double.compare(position2.y, y) == 0;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

package com.exercise.shape.shapes;

import com.exercise.math.Position;
import com.exercise.shape.InvalidSizeException;
import com.exercise.shape.Shape;

public final class Circle extends Shape {

    private final double radius;

    /**
     *
     * @param position
     * @param radius
     * @throws  InvalidSizeException
     */
    public Circle(final Position position, final double radius) {
        super(position);
        if (radius < 0.0) {
            throw new InvalidSizeException(String.format("Radius %f is invalid (must not be negative) for Circle", radius));
        }

        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        if (area == null) {
            area = radius * radius * Math.PI;
        }
        return area;
    }

    @Override
    public String getShape() {
        return "Cycle";
    }
}

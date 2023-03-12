package com.exercise.shape.shapes;

import com.exercise.math.Position;
import com.exercise.shape.InvalidSizeException;
import com.exercise.shape.Shape;

public final class Triangle extends Shape {

    private final double x;
    private final double y;

    public Triangle(final Position position, final double x, final double y) {
        super(position);

        if (x < 0.0 || y < 0.0) {
            throw new InvalidSizeException(String.format("X: %f or Y: %f is invalid (must not be negative) for Triangle", x, y));
        }

        this.x = x;
        this.y = y;
    }

    @Override
    public double calculateArea() {
        if (area == null) {
            area = x * y / 2.0;
        }
        return area;
    }

    @Override
    public String getShape() {
        return "Triangle";
    }
}

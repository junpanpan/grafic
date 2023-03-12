package com.exercise.shape;

import com.exercise.math.Position;

import java.util.Objects;

public abstract class Shape implements Comparable<Shape> {

    private final Position position;
    protected Double area;

    public Shape(Position position) {
        Objects.nonNull(position);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    /**
     * Calculates the area of the Shape and returns it
     *
     * @return the area of the Shape
     */
    public abstract double calculateArea();

    /**
     * What kind of shape
     * @return
     */
    public abstract String getShape();

    @Override
    public int compareTo(Shape o) {
        return Double.compare(this.calculateArea(), o.calculateArea());
    }

    public double distance(Shape shape) {
        return this.position.distance(shape.position);
    }
}

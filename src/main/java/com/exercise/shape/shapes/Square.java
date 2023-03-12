package com.exercise.shape.shapes;

import com.exercise.math.Position;

public final class Square extends Rectangle {

    public Square(final Position position, final double x) {
        super(position, x, x);
    }

    @Override
    public String getShape() {
        return "Square";
    }
}

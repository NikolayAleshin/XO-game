package com.aleshin.xo.model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getFieldSize() {
        final Field field = new Field();
        assertEquals(3, field.getFieldSize());
    }

    @Test
    void setFigure() {
        final Field field = new Field();
        final Point point = new Point(0, 0);
        final Figure figure = Figure.O;
        field.setFigure(point, figure);
        final Figure actualFigure = field.getFigure(point);

        assertEquals(figure, actualFigure);
    }
}
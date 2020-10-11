package com.aleshin.xo.model;

import com.aleshin.xo.model.exceptions.AlreadyOccupiedException;
import com.aleshin.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void testGetFieldSize() {
        final Field field = new Field();
        assertEquals(3, field.getFieldSize());
    }

    @Test
    void testSetFigure() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point point = new Point(0, 0);
        final Figure figure = Figure.O;
        field.setFigure(point, figure);
        final Figure actualFigure = field.getFigure(point);

        assertEquals(figure, actualFigure);
    }

    @Test
    void testSetFigureWhenAlreadyOccupied() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point point = new Point(0, 0);
        final Figure figure = Figure.O;
        field.setFigure(point, figure);
        try {
            field.setFigure(point, figure);
            fail();
        } catch (final AlreadyOccupiedException e) {}
    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws InvalidPointException {
        final Field field = new Field();
        final Point point = new Point(0, 0);

        final Figure actualFigure = field.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    void testGetFigureWhenXIsLessThenZero() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point point = new Point(-1, 0);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsLessThenZero() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point point = new Point(0, -1);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenXIsMoreThenSize() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point point = new Point(field.getFieldSize() + 1, 0);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsMoreThenSize() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point point = new Point(0, field.getFieldSize() + 1);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {}
    }
}
package com.aleshin.xo.controllers;

import com.aleshin.xo.model.Field;
import com.aleshin.xo.model.Figure;
import com.aleshin.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove (final Field field) throws InvalidPointException {
        int countFigure = 0;

        for (int x = 0; x < field.getFieldSize(); x++) {
            countFigure += countFigureRow(field, x);
        }
        if (countFigure == field.getFieldSize() * field.getFieldSize()) {
            return null;
        }

        if (countFigure % 2 == 0) {
            return Figure.X;
        }
        return Figure.O;
    }

    private int countFigureRow(final Field field, final int row) throws InvalidPointException {
        int countFigure = 0;
        for (int x = 0; x < field.getFieldSize(); x++) {
            if (field.getFigure(new Point(x, row)) != null) countFigure++;
        }
        return countFigure;
    }
}

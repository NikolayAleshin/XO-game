package com.aleshin.xo.controllers;

import com.aleshin.xo.model.Field;
import com.aleshin.xo.model.Figure;
import com.aleshin.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerContoller {

    public Figure getWinner(final Field field) {
        try {
            for(int i = 0; i < 3; i++) {
                if (checkWinner(field, new Point(i,0), p -> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
                if (checkWinner(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) {
                    return field.getFigure(new Point(0, i));
                }
                if (checkWinner(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
                    return field.getFigure(new Point(0, 0));
                }
                if (checkWinner(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))) {
                    return field.getFigure(new Point(1, 1));
                }
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        } {

        }
        return null;
    }

    private boolean checkWinner(final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {

        final Figure currentFigure;
        final Figure nextFigure;
        final Point pointNext = pointGenerator.nextPoint(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return checkWinner(field, pointNext, pointGenerator);
    }

    private interface IPointGenerator {
        Point nextPoint(final Point point);
    }
}

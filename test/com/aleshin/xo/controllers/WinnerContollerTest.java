package com.aleshin.xo.controllers;

import com.aleshin.xo.model.Field;
import com.aleshin.xo.model.Figure;
import com.aleshin.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerContollerTest {

    @Test
    void testGetWinnerWhenWinnerRow() throws InvalidPointException {
        final WinnerContoller winnerContoller = new WinnerContoller();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerContoller.getWinner(field));
        }
    }

    @Test
    void testGetWinnerWhenWinnerColumn() throws InvalidPointException {
        final WinnerContoller winnerContoller = new WinnerContoller();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerContoller.getWinner(field));
        }
    }

    @Test
    void testGetWinnerWhenNotWinnerRow() throws InvalidPointException {
        final WinnerContoller winnerContoller = new WinnerContoller();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerContoller.getWinner(field));
        }
    }

    @Test
    void testGetWinnerWhenNotWinnerColumn() throws InvalidPointException {
        final WinnerContoller winnerContoller = new WinnerContoller();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerContoller.getWinner(field));
        }
    }

    @Test
    void testGetWinnerWhenWinnerDiaganal1() throws InvalidPointException {
        final WinnerContoller winnerContoller = new WinnerContoller();
            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.X);
            assertEquals(Figure.X, winnerContoller.getWinner(field));
    }

    @Test
    void testGetWinnerWhenNotWinnerDiaganal1() throws InvalidPointException {
        final WinnerContoller winnerContoller = new WinnerContoller();
            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.O);
            assertNull(winnerContoller.getWinner(field));
    }

    @Test
    void testGetWinnerWhenWinnerDiaganal2() throws InvalidPointException {
        final WinnerContoller winnerContoller = new WinnerContoller();
        final Field field = new Field(3);
        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(0, 2), Figure.X);
        assertEquals(Figure.X, winnerContoller.getWinner(field));
    }

    @Test
    void testGetWinnerWhenNotWinnerDiaganal2() throws InvalidPointException {
        final WinnerContoller winnerContoller = new WinnerContoller();
        final Field field = new Field(3);
        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(0, 2), Figure.O);
        assertNull(winnerContoller.getWinner(field));
    }
}
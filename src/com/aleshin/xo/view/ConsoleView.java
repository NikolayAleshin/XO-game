package com.aleshin.xo.view;

import com.aleshin.xo.controllers.CurrentMoveController;
import com.aleshin.xo.controllers.MoveController;
import com.aleshin.xo.controllers.WinnerContoller;
import com.aleshin.xo.model.Field;
import com.aleshin.xo.model.Figure;
import com.aleshin.xo.model.Game;
import com.aleshin.xo.model.exceptions.AlreadyOccupiedException;
import com.aleshin.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerContoller winnerContoller = new WinnerContoller();
    private final MoveController moveController = new MoveController();

    public void show(Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getFieldSize(); x++) {
            if (x != 0) printSeparator();
            printLine(field, x);
        }
    }



    public boolean move(Game game) throws InvalidPointException {
        final Field field = game.getField();
        final Figure winner = winnerContoller.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no move left");
            return false;
        }
        System.out.format("Please enter coordinate for: %s ", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (AlreadyOccupiedException | InvalidPointException e) {
            //e.printStackTrace();
            System.out.println("Point is invalid");
        }
        return true;
    }

    private Point askPoint () {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please press coordinate: %s", coordinateName);
        final Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Point is invalid");
            return askCoordinate(coordinateName);
        }

    }

    private void printLine(final Field field, final int x) {

        for (int y = 0; y < field.getFieldSize(); y++) {
            if (y != 0) System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("------------");
    }
}

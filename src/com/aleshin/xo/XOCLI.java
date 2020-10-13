package com.aleshin.xo;

import com.aleshin.xo.model.Field;
import com.aleshin.xo.model.Game;
import com.aleshin.xo.model.Player;
import com.aleshin.xo.model.exceptions.InvalidPointException;
import com.aleshin.xo.view.ConsoleView;

public class XOCLI {
    public static void main(final String[] args) throws InvalidPointException {
        final String name1 = "Gleb";
        final String name2 = "Slava";

        final Player[] players = new Player[2];

        final Game gameXo = new Game(players, new Field(3), "XO");
        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXo);
        while (consoleView.move(gameXo)) {
            consoleView.show(gameXo);
        }

    }
}

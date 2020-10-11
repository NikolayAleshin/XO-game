package com.aleshin.xo.model;

public class Player {

    private final String namePlayer;

    private final Figure figure;

    public Player(final String namePlayer, final Figure figure) {
        this.namePlayer = namePlayer;
        this.figure = figure;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public Figure getFigure() {
        return figure;
    }
}

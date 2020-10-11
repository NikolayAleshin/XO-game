package com.aleshin.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getNamePlayer() {
        final String inputValue = "TestUser";
        Player player = new Player(inputValue, null);
        final String actualValue = player.getNamePlayer();

        assertEquals(inputValue, actualValue);
    }

    @Test
    void getFigure() {
        final Figure inputValue = Figure.X;
        Player player = new Player(null, inputValue);
        final Figure actualValue = player.getFigure();

        assertEquals(inputValue, actualValue);
    }
}
package com.sibirbear.study.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        final String testName = "Igor";
        final String expectedName = testName;

        final Player player = new Player (testName, null);

        final String actualName = player.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getFigure() {
        final Figure testFigure = Figure.X;
        final Figure expectedFigure = testFigure;

        final Player player = new Player(null, testFigure);

        final Figure actualFigure = player.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }
}
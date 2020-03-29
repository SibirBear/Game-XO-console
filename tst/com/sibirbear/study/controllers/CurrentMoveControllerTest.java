package com.sibirbear.study.controllers;

import com.sibirbear.study.model.Field;
import com.sibirbear.study.model.Figure;
import com.sibirbear.study.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenNextMoveX() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for(int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveWhenNextMoveO() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            field.setFigure(new Point(i, 1), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveWhenNoNextMove() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        Field field = new Field(3);
        for (int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                field.setFigure(new Point(x, y), Figure.X);
            }
        }
        assertNull(currentMoveController.currentMove(field));
    }
}
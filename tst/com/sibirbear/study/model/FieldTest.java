package com.sibirbear.study.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() {
        final Field field = new Field();
        final Point testPoint = new Point(0,0);
        final Figure testFigure = Figure.O;

        field.setFigure(testPoint, testFigure);
        final Figure actualFigure = field.getFigure(testPoint);
        assertEquals(testFigure, actualFigure);
    }
}
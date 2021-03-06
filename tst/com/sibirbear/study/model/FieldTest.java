package com.sibirbear.study.model;

import com.sibirbear.study.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field<Figure> field = new Field<>(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point testPoint = new Point(0,0);
        final Figure testFigure = Figure.O;

        field.setFigure(testPoint, testFigure);
        final Figure actualFigure = field.getFigure(testPoint);
        assertEquals(testFigure, actualFigure);
    }

    @Test
    public void TestGetFigureWhenFigureIsNotSet() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point testPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(testPoint);
        assertNull(actualFigure);
    }

    @Test
    public void TestGetFigureWhenXIsLessThenZero() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point testPoint = new Point(-1,0);

        try {
            field.getFigure(testPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void TestGetFigureWhenYIsLessThenZero() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point testPoint = new Point(0,-1);

        try {
            field.getFigure(testPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void TestGetFigureWhenXMoreThenFieldSize() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point testPoint = new Point(field.getSize() + 1,0);

        try {
            field.getFigure(testPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void TestGetFigureWhenYIsLessFieldSize() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point testPoint = new Point(0,field.getSize() + 1);

        try {
            field.getFigure(testPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
}
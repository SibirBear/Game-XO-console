package com.sibirbear.study.controllers;

import com.sibirbear.study.model.Field;
import com.sibirbear.study.model.Figure;
import com.sibirbear.study.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field<Figure> field) throws InvalidPointException {
        int countFigure = 0;
        for(int y = 0; y < field.getSize(); y++) {
            countFigure += countFigureInTheRow(field, y);
        }

        if(countFigure == field.getSize() * field.getSize())
            return null;

        if(countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFigureInTheRow(final Field<Figure> field,final int row) throws InvalidPointException {
        int countFigure = 0;
        for(int x = 0; x < field.getSize(); x++) {
            if(field.getFigure(new Point(x, row)) != null)
                countFigure++;
            }

        return countFigure;
    }

}

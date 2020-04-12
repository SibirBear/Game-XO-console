package com.sibirbear.study.controllers;

import com.sibirbear.study.model.Field;
import com.sibirbear.study.model.Figure;
import com.sibirbear.study.model.exceptions.InvalidPointException;
import com.sibirbear.study.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field<Figure> field,
                            final Figure figure,
                            final Point point)
            throws InvalidPointException,
                   PointAlreadyOccupiedException {

        if(field.getFigure(point) != null) {
            throw new PointAlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }

}

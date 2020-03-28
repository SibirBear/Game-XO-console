package com.sibirbear.study.model;

import com.sibirbear.study.model.exceptions.InvalidPointException;
import com.sibirbear.study.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;
    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if(checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure)
                                throws InvalidPointException {
        
        if(checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(Point point) {
        return checkCoordinate(point.x) || checkCoordinate(point.y);
    }

    private boolean checkCoordinate (final int coordinate){
        return coordinate < MIN_COORDINATE || coordinate >= MAX_COORDINATE;
    }

}

package com.sibirbear.study.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Game<F> implements Iterable<Player> {

    private final Player[] players;
    private final Field<F> field;
    private final String name;

    public Game(final Player[] players, final Field<F> field,
                final String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field<F> getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return Game.this.players.length > index;
        }

        @Override
        public Player next() {
            return Game.this.players[index++];
        }
    }

}

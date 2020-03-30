package com.sibirbear.study;

import com.sibirbear.study.model.Field;
import com.sibirbear.study.model.Figure;
import com.sibirbear.study.model.Game;
import com.sibirbear.study.model.Player;
import com.sibirbear.study.model.exceptions.InvalidPointException;
import com.sibirbear.study.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Bear";
        final String name2 = "Rabbit";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while(true) {
            try {
                if (!consoleView.move(gameXO)) break;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
            consoleView.show(gameXO);
        }
    }

}

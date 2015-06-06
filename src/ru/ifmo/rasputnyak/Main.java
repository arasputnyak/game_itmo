package ru.ifmo.rasputnyak;

import ru.ifmo.rasputnyak.Field;

import javax.swing.*;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        final Field field = new Field(7);
=======
        final Field field = new Field(3);
>>>>>>> t01
        final Game newGame = new Game(field);

        newGame.startNewGame();

        FrameField frame = new FrameField(field, newGame);
        frame.setVisible(true);
    }
}

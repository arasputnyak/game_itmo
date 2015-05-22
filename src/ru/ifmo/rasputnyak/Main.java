package ru.ifmo.rasputnyak;

import ru.ifmo.rasputnyak.Field;

import javax.swing.*;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        final Field field = new Field(13);
        final Game newGame = new Game(field);

        newGame.startNewGame();

        FrameField frame = new FrameField(field, newGame);
        frame.setVisible(true);
    }
}
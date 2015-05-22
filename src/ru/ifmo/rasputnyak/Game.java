package ru.ifmo.rasputnyak;

/**
 * Created by Владелец on 20.05.2015.
 */
public class Game {
    private final Field field;
    public Game(final Field field) {
        this.field = field;
    }
    public void startNewGame() {
        field.reset();
    }
}


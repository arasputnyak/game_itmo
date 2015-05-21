package ru.ifmo.rasputnyak;

/**
 * Created by Владелец on 20.05.2015.
 */
public class Game {
    int n;
    public Game(int n) {
        this.n = n;
    }
    public void startNewGame() {
        Field field = new Field(n);
        field.fillPole();
        while (field.checkLine() == true) {
            field.removeBalls();
            while (field.noBalls()) {
                field.replaceBalls();
            }
        }
        FrameField frame = new FrameField(field);
        frame.setVisible(true);
    }
}


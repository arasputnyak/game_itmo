package ru.ifmo.rasputnyak;

import ru.ifmo.rasputnyak.Field;

import javax.swing.*;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field(15);
        field.fillPole();
            while (field.checkline() == true) {
                field.removeBalls();
                while (field.noBalls()) {
                    field.replaceBalls();
                }
            }
        FrameField frame = new FrameField(field);
        frame.setVisible(true);

    }
}

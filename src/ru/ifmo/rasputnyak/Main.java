package ru.ifmo.rasputnyak;

import ru.ifmo.rasputnyak.Field;

import javax.swing.*;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        int count;
        count = 0;
        Field field = new Field(15);
        Player player = new Player();
        Command makeStepCmd = new MakeStepCommand(player, field);
        field.fillPole();

        FrameField frame = new FrameField(field);
        frame.setVisible(true);
        //frame.setSize(400, 400);
        //frame.setResizable(false);
        //frame.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println(field);
        System.out.println("текущий счет: 0");
        frame.fieldChanged1();
        while (field.checkField() == true) {
            while (field.checkline() == true) {
                field.removeBalls();
                while (field.noBalls() == true) {
                    field.replaceBalls();
                }
            }
            System.out.println(field);
            frame.fieldChanged();
            makeStepCmd.execute();
            count = count + field.getScore3();
            count = count + field.getScore2();
            count = count + field.getScore1();
            System.out.println(field);
            System.out.println("Текущий счет: " + count);
            frame.fieldChanged();
        }
        System.out.println("Игра окончена");
        frame.fieldChanged();
    }
}

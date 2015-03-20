package ru.ifmo.rasputnyak;

import ru.ifmo.rasputnyak.Field;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        int count;
        count = 0;
        Field field = new Field(15);
        Player player = new Player();
        //ru.ifmo.rasputnyak.Command makeStepCmd = new ru.ifmo.rasputnyak.MakeStepCommand(player);
        field.fillPole();
        System.out.println(field);
        while (field.checkField() == true) {
            while (field.checkline() == true) {
                field.removeBalls();
                while (field.noBalls() == true) {
                    field.replaceBalls();
                }
            }
            System.out.println(field);
            player.makeStep(field);
            //makeStepCmd.execute();
            count = count + field.getScore3();
            count = count + field.getScore2();
            count = count + field.getScore1();
            System.out.println(field);
            System.out.println("Текущий счет: " + count);
        }
        System.out.println("Игра окончена");
    }
}

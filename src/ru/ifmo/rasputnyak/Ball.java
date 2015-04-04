package ru.ifmo.rasputnyak;

import java.util.Random;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Ball implements BallGenerator {
    char color;
    public String getColor() {
        final String letter = "YRBGV";
        Random random = new Random();
        color = letter.charAt(random.nextInt(4));
        return String.valueOf(color);
    }
}

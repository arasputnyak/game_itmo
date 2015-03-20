package ru.ifmo.rasputnyak;

import java.util.Random;

/**
 * Created by Владелец on 17.03.2015.
 */
public class Cell {
    public enum Color {
        Y, R, G, B, V, _
    }

    public Color getColor() {
        Random random = new Random();
        int k;
        Color cell;
        cell = Color._;
        k = random.nextInt(4);
        if (k == 0) {
            cell = Color.B;
        }
        if (k == 1) {
            cell = Color.G;
        }
        if (k == 2) {
            cell = Color.R;
        }
        if (k == 3) {
            cell = Color.V;
        }
        if (k == 4) {
            cell = Color.Y;
        }
        return cell;
    }
}
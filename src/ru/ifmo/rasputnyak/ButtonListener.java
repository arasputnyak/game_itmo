package ru.ifmo.rasputnyak;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Владелец on 02.04.2015.
 */
public class ButtonListener implements ActionListener {
    private final Field field;
    private final RoundButton[][] buttons;
    final int length;
    public ButtonListener(Field field){
        this.field = field;
        this.length = field.size();
        this.buttons = new RoundButton[length][length];
    }
    public void actionPerformed(ActionEvent e) {
        //System.out.println("" + e.getSource());
        boolean f;
        f = false;
        int x = -1;
        int y = -1;
        int z = -1;
        int t = -1;
        while (f == false) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        x = i;
                        y = j;
                        //System.out.println(x + " " + y);
                    }
                }
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        z = i;
                        t = j;
                    }
                }
            }
            if (Math.abs(x - z) <= 1 && Math.abs(y - t) <= 1) {
                RoundButton value1;
                RoundButton value2;
                value1 = buttons[x][y];
                value2 = buttons[z][t];
                buttons[x][y] = value2;
                buttons[z][t] = value1;
                f = true;
            }
        }
    }
}

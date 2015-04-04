package ru.ifmo.rasputnyak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Владелец on 15.03.2015.
 */
public class FrameField extends JFrame {
    private Field field;
    private JButton[][] buttons;
    JLabel label;
    JTextField textField;
    int count;

    public FrameField(final Field field) {
        super("Name");
        this.field = field;
        JPanel panel = new JPanel();
        final int length = field.size();
        count = 0;
        label = new JLabel("Текущий счет: " + count);
        add(label);
        buttons = new JButton[length][length];
        panel.setLayout(new GridLayout(length, length, 2, 2));
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                JButton button = new JButton(field.getMeaning(i, j).toString());
                ActionListener actionListener = new ButtonListener();
                button.addActionListener(actionListener);
                panel.add(button);
                buttons[i][j] = button;
            }
        }
        setSize(400, 400);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void fieldChanged() {
        final int length = field.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                buttons[i][j].setText(field.getMeaning(i, j).toString());
            }
        }
        count = count + field.getScore3();
        count = count + field.getScore2();
        count = count + field.getScore1();
    }
}

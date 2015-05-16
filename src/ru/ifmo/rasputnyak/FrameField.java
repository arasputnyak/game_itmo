package ru.ifmo.rasputnyak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Владелец on 15.03.2015.
 */
public class FrameField extends JFrame implements FieldObserver {
    private Field field;
    private JButton[][] buttons;
    JLabel label;
    int count;

    public FrameField(final Field field) {
        super("Игровое окно");
        this.field = field;
        this.field.addObserver(this);
        JPanel panel = new JPanel();
        final int length = field.size();
        count = 0;
        label = new JLabel("Текущий счет: " + count);
        label.setFont(new Font("Courier New", Font.ITALIC, 20));
        add(label);
        buttons = new RoundButton[length][length];
        panel.setLayout(new GridLayout(length, length, 4, 4));
        panel.setBackground(Color.decode("#FFFFF0"));
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(label, BorderLayout.NORTH);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                RoundButton button = new RoundButton(field.getMeaning(i, j).toString());
                panel.add(button);
                buttons[i][j] = button;
                if (field.getMeaning(i, j).equals(Cell.Color.R)) {
                    button.setBackground(Color.decode("#DC143C"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.G)) {
                    button.setBackground(Color.decode("#32CD32"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.V)) {
                    button.setBackground(Color.decode("#9932CC"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.B)) {
                    button.setBackground(Color.decode("#00BFFF"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.Y)) {
                    button.setBackground(Color.decode("#FFFF00"));
                }
                //button.setPreferredSize(new Dimension(10, 10));
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x1 = -1;
                        int y1 = -1;
                        int x = -1;
                        int y = -1;
                        int length = field.size();
                        for (int i = 0; i < length; i++) {
                            for (int j = 0; j < length; j++) {
                                if (x > -1 && y > -1) {
                                x1 = i;
                                y1 = j;
                                } else  {
                                    x = i;
                                    y = j;
                                }
                            }
                        }
                        field.changeMeaning(x, y, x1, y1, field);
                    }
                });
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
                if (field.getMeaning(i, j).equals(Cell.Color.R)) {
                    buttons[i][j].setBackground(Color.decode("#DC143C"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.G)) {
                    buttons[i][j].setBackground(Color.decode("#32CD32"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.V)) {
                    buttons[i][j].setBackground(Color.decode("#9932CC"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.B)) {
                    buttons[i][j].setBackground(Color.decode("#00BFFF"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.Y)) {
                    buttons[i][j].setBackground(Color.decode("#FFFF00"));
                }
            }
        }
        count = count + field.getScore3();
        count = count + field.getScore2();
        count = count + field.getScore1();
        label.setText("Текущий счет: " + count);
    }
}

package ru.ifmo.rasputnyak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Владелец on 15.03.2015.
 */
public class FrameField extends JFrame implements FieldObserver {
    private final Field field;
    private final RoundButton[][] buttons;
    private final JLabel label;
    private final JLabel label1;
    int n = 100;
    int timer = n;

    int count;
    int x = -1;
    int y = -1;

    public FrameField(final Field field, final Game game) {
        super("Игровое окно");
        this.field = field;
        this.field.addObserver(this);
        JPanel panel = new JPanel();
        final int length = field.size();
        count = 0;
        label = new JLabel("SCORE:  " + count);
        label.setFont(new Font("Old English Text MT", Font.ITALIC, 25));
        add(label);
        label1 = new JLabel("Time: ");
        label1.setFont(new Font("Gloucester MT Extra Condensed", Font.ITALIC, 20));
        add(label1);
        javax.swing.Timer swingTimer = new javax.swing.Timer(
                1000,
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label1.setText("Time: "
                                + String.valueOf(timer));
                        timer--;
                        if (timer == 0) {
                            JOptionPane.showMessageDialog(null, "Игра окончена!" + "\n" + "Ваш результат: " + count + " очков");
                            game.startNewGame();
                            fieldChanged();
                            timer = n;
                            count = 0;
                            label.setText("SCORE: " + count);
                        }
                    }
                });
        swingTimer.start();
        buttons = new RoundButton[length][length];
        panel.setLayout(new GridLayout(length, length, 4, 4));
        panel.setBackground(Color.decode("#FFFFF0"));
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(label, BorderLayout.NORTH);
        getContentPane().add(label1, BorderLayout.SOUTH);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                RoundButton button = new RoundButton("");
                panel.add(button);
                buttons[i][j] = button;
                if (field.getMeaning(i, j).equals(Cell.Color.R)) {
                    button.setBackground(Color.decode("#8B0000"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.G)) {
                    button.setBackground(Color.decode("#000000"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.V)) {
                    button.setBackground(Color.decode("#808080"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.B)) {
                    button.setBackground(Color.decode("#DCDCDC"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.Y)) {
                    button.setBackground(Color.decode("#CC0000"));
                }
                //button.setPreferredSize(new Dimension(10, 10));
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                final int i1 = i;
                final int j1 = j;
                buttons[i1][j1].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (field.checkField() == false) {
                            JOptionPane.showMessageDialog(null, "Нет возможных комбинаций!" + "\n" + "Сейчас начнется новая игра");
                            x = -1;
                            y = -1;
                            game.startNewGame();
                            fieldChanged();
                            count = 0;
                            timer = n;
                            label.setText("SCORE: " + count);
                        }
                        int x1 = -1;
                        int y1 = -1;
                        if (x > -1 && y > -1) {
                            x1 = i1;
                            y1 = j1;
                            if (Math.abs(x - x1) <= 1 && Math.abs(y - y1) <= 1) {
                                field.changeMeaning(x, y, x1, y1, field);
                                try {
                                    while (field.checkLine() == true) {
                                        field.removeBalls();
                                        fieldChanged();
                                        Thread.sleep(150);
                                        while (field.noBalls() == true) {
                                            field.replaceBalls();
                                            fieldChanged();
                                        }

                                    }
                                    getCount();
                                    label.setText("SCORE: " + count);
                                    x = -1;
                                    y = -1;
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Эти шарики нельзя поменять местами!" + "\n" + "Выберите другие два ");
                                x = -1;
                                y = -1;
                            }
                        } else  {
                            x = i1;
                            y = j1;
                        }
                    }
                });
            }
        }

        setSize(400, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Bernard MT Condensed", Font.PLAIN, 11);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem item = new JCheckBoxMenuItem("New Game");
        menu.add(item);
        menuBar.setFont(font);
        menu.setFont(font);
        item.setFont(font);
        this.setJMenuBar(menuBar);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reply = JOptionPane.showConfirmDialog(null, "Начать новую игру?", "New Game", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    game.startNewGame();
                    fieldChanged();
                    count = 0;
                    timer = n;
                    label.setText("SCORE: " + count);
                }
            }
        });
    }
    public void fieldChanged() {
        final int length = field.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                buttons[i][j].setText("");
                if (field.getMeaning(i, j).equals(Cell.Color.R)) {
                    buttons[i][j].setBackground(Color.decode("#8B0000"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.G)) {
                    buttons[i][j].setBackground(Color.decode("#000000"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.V)) {
                    buttons[i][j].setBackground(Color.decode("#808080"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.B)) {
                    buttons[i][j].setBackground(Color.decode("#DCDCDC"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color.Y)) {
                    buttons[i][j].setBackground(Color.decode("#CC0000"));
                }
                if (field.getMeaning(i, j).equals(Cell.Color._)) {
                    buttons[i][j].setBackground(Color.decode("#000000"));
                }
            }
            //count = count + field.score;
            //label.setText("Текущий счет: " + count);
        }
    }
    public void getCount() {
        count = count + field.score;
    }
}
package ru.ifmo.rasputnyak;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Владелец on 15.03.2015.
 */
public class FrameField extends JFrame {
    JLabel label;
    JTextField textField;
    public FrameField() {
        super("Name");
        setLayout(new FlowLayout());
        label = new JLabel("Текущий счет: ");
        textField = new JTextField(10);
        add(label);
        add(textField);
    }
    public static void main(String[] args) {
        FrameField frame = new FrameField();
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

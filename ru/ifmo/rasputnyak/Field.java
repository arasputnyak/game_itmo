package ru.ifmo.rasputnyak;

import ru.ifmo.rasputnyak.Cell;

import java.util.Scanner;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Field {
    int length;
    public Field(int length) {
        this.length = length;
    }
    private final Cell.Color[][] matrixPole = new Cell.Color[length][length];
    Cell matrixCell = new Cell();
    public void fillPole() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrixPole[i][j] = matrixCell.getColor();
            }
        }
    }
    public Cell.Color getMeaning(int x, int y) {
        return matrixPole[x][y];
    }
    public void changeMeaning() {
        boolean f;
        f = false;
        int x;
        int y;
        int z;
        int t;
        Scanner scanner = new Scanner(System.in);
        while (f == false) {
            System.out.println("Введите коорднаты1:\n" + "x=");
            x = scanner.nextInt();
            System.out.println("y=");
            y = scanner.nextInt();
            Cell.Color value1;
            value1 = matrixPole[x][y];
            System.out.println("Введите коорднаты2:\n" + "z=");
            z = scanner.nextInt();
            System.out.println("t=");
            t = scanner.nextInt();
            Cell.Color value2;
            if (Math.abs(x - z) <= 1 && Math.abs(y - t) <= 1) {
                value2 = matrixPole[z][t];
                matrixPole[x][y] = value2;
                matrixPole[z][t] = value1;
                f = true;
            } else {
                System.out.println("Такой ход сделать нельзя");
            }
        }
    }

    public int getScore1() {
        int counter;
        counter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 2; j++) {
                if (matrixPole[i][j].equals(matrixPole[i][j + 1]) && matrixPole[i][j].equals(matrixPole[i][j + 2])) {
                    counter = counter + 10;
                }
            }
        }
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length - 2; i++) {
                if (matrixPole[i][j].equals(matrixPole[i + 1][j]) && matrixPole[i][j].equals(matrixPole[i + 2][j])) {
                    counter = counter + 10;
                }
            }
        }
        return counter;
    }
    public int getScore2() {
        int counter;
        counter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 5; j++) {
                if (matrixPole[i][j].equals(matrixPole[i][j + 1]) && matrixPole[i][j].equals(matrixPole[i][j + 2]) && matrixPole[i][j].equals(matrixPole[i][j + 3]) || matrixPole[i][j].equals(matrixPole[i][j + 1]) && matrixPole[i][j].equals(matrixPole[i][j + 2]) && matrixPole[i][j].equals(matrixPole[i][j + 3]) && matrixPole[i][j].equals(matrixPole[i][j + 4])) {
                    counter = counter + 20;
                }
            }
        }
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length - 5; i++) {
                if (matrixPole[i][j].equals(matrixPole[i + 1][j]) && matrixPole[i][j].equals(matrixPole[i + 2][j]) && matrixPole[i][j].equals(matrixPole[i + 3][j]) || matrixPole[i][j].equals(matrixPole[i + 1][j]) && matrixPole[i][j].equals(matrixPole[i + 2][j]) && matrixPole[i][j].equals(matrixPole[i + 3][j]) && matrixPole[i][j].equals(matrixPole[i + 4][j])) {
                    counter = counter + 20;
                }
            }
        }
        return counter;
    }
    public int getScore3() {
        int counter;
        counter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 6; j++) {
                if (matrixPole[i][j].equals(matrixPole[i][j + 1]) && matrixPole[i][j].equals(matrixPole[i][j + 2]) && matrixPole[i][j].equals(matrixPole[i][j + 3]) && matrixPole[i][j].equals(matrixPole[i][j + 4]) && matrixPole[i][j].equals(matrixPole[i][j + 5])) {
                    counter = counter + 30;
                }
            }
        }
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length - 6; i++) {
                if (matrixPole[i][j].equals(matrixPole[i + 1][j]) && matrixPole[i][j].equals(matrixPole[i + 2][j]) && matrixPole[i][j].equals(matrixPole[i + 3][j]) && matrixPole[i][j].equals(matrixPole[i + 4][j]) && matrixPole[i][j].equals(matrixPole[i + 5][j])) {
                    counter = counter + 30;
                }
            }
        }
        return counter;
    }
    public boolean checkField() {
        boolean check = false;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 2; j++) {
                if (matrixPole[i][j].equals(matrixPole[i + 1][j + 1]) && matrixPole[i][j].equals(matrixPole[i][j + 2]) || matrixPole[i+1][j].equals(matrixPole[i][j + 1]) && matrixPole[i + 1][j].equals(matrixPole[i + 1][j + 2]) || matrixPole[i][j].equals(matrixPole[i][j + 1]) && matrixPole[i][j].equals(matrixPole[i + 1][j + 2]) || matrixPole[i + 1][j].equals(matrixPole[i + 1][j + 1]) && matrixPole[i + 1][j].equals(matrixPole[i][j + 2]) || matrixPole[i + 1][j].equals(matrixPole[i][j + 1]) && matrixPole[i + 1][j].equals(matrixPole[i][j + 2]) || matrixPole[i][j].equals(matrixPole[i + 1][j + 1]) && matrixPole[i][j].equals(matrixPole[i + 1][j + 2])) {
                    check = true;
                }
            }
        }
        for (int j = 0; j < length - 1; j++) {
            for (int i = 0; i < length - 2; i++) {
                if (matrixPole[i][j].equals(matrixPole[i + 1][j + 1]) && matrixPole[i][j].equals(matrixPole[i + 2][j]) || matrixPole[i][j + 1].equals(matrixPole[i + 1][j]) && matrixPole[i][j + 1].equals(matrixPole[i + 2][j + 1]) || matrixPole[i][j].equals(matrixPole[i + 1][j + 1]) && matrixPole[i][j].equals(matrixPole[i + 2][j + 1]) || matrixPole[i][j + 1].equals(matrixPole[i + 1][j]) && matrixPole[i][j + 1].equals(matrixPole[i + 2][j]) || matrixPole[i][j + 1].equals(matrixPole[i + 1][j + 1]) && matrixPole[i][j + 1].equals(matrixPole[i + 2][j]) || matrixPole[i][j].equals(matrixPole[i + 1][j]) && matrixPole[i][j].equals(matrixPole[i + 2][j + 1])) {
                    check = true;
                }
            }
        }
        return check;
    }
    public void removeBalls() {
        int sum;
        sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (matrixPole[i][j].equals(matrixPole[i][k]) && !(matrixPole[i][j].equals(Cell.Color._))) {
                        sum = sum + 1;
                    } else {
                        break;
                    }
                    if (sum >= 2) {
                        for (int m = j; m < j + sum + 1; m++) {
                            matrixPole[i][m] = Cell.Color._;
                        }
                    }
                    }
                sum = 0;
                }
            }
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length; i++) {
                for (int k = i + 1; k < length; k++) {
                    if (matrixPole[i][j].equals(matrixPole[k][j]) && !(matrixPole[i][j].equals(Cell.Color._))) {
                        sum = sum + 1;
                    } else {
                        break;
                    }
                    if (sum >= 2) {
                        for (int m = i; m < i + sum + 1; m++) {
                            matrixPole[m][j] = Cell.Color._;
                        }
                    }
                }
                sum = 0;
            }
        }
        }
    public void replaceBalls() {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (matrixPole[i][j].equals("_")) {
                        if (i == 0) {
                            matrixPole[i][j] = matrixCell.getColor();
                        } else {
                            matrixPole[i][j] = matrixPole[i - 1][j];
                            matrixPole[i - 1][j] = Cell.Color._;
                        }
                    }
                }
            }
        }

    public boolean noBalls() {
        boolean f = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrixPole[i][j].equals("_")) {
                    f = true;
                }
            }
        }
        return f;
    }
    public void addBalls() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrixPole[i][j].equals("_")) {
                    matrixPole[i][j] = matrixCell.getColor();
                }
            }
        }
    }
    public boolean checkline() {
        boolean f = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 2; j++) {
                if (matrixPole[i][j].equals(matrixPole[i][j + 1]) && matrixPole[i][j].equals(matrixPole[i][j + 2])) {
                    f = true;
                }
            }
        }
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length - 2; i++) {
                if (matrixPole[i][j].equals(matrixPole[i + 1][j]) && matrixPole[i][j].equals(matrixPole[i + 2][j])) {
                    f = true;
                }
            }
        }
        return f;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                s += getMeaning(i, j) + " ";
            }
            s += "\n";
        }
        return s;
    }
}






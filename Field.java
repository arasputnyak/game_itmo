import java.util.Scanner;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Field {
    private final String[][] matrixPole = new String[15][15];
    Ball ball = new Ball();
    public void fillPole() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matrixPole[i][j] = ball.getColor();
            }
        }
    }
    public String getMeaning(int x, int y) {
        return matrixPole[x][y];
    }
    public void changeMeaning() {
        int x;
        int y;
        int z;
        int t;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        System.out.println("Введите коорднаты1:\n" + "x=" + x + " y=" + y);
        String value1;
        value1 = matrixPole[x][y];
        z = scanner.nextInt();
        t = scanner.nextInt();
        System.out.println("Введите коорднаты2:\n" + "z=" + z + " t=" + t);
        String value2;
        value2 = matrixPole[z][t];
        matrixPole[x][y] = value2;
        matrixPole[z][t] = value1;
    }

    public int getScore1() {
        int counter;
        counter = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 13; j++) {
                if (matrixPole[i][j] == matrixPole[i][j + 1] && matrixPole[i][j] == matrixPole[i][j + 2]) {
                    counter = counter + 10;
                }
            }
        }
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 13; i++) {
                if (matrixPole[i][j] == matrixPole[i + 1][j] && matrixPole[i][j] == matrixPole[i + 2][j]) {
                    counter = counter + 10;
                }
            }
        }
        return counter;
    }
    public int getScore2() {
        int counter;
        counter = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrixPole[i][j] == matrixPole[i][j + 1] && matrixPole[i][j] == matrixPole[i][j + 2] && matrixPole[i][j] == matrixPole[i][j + 3] || matrixPole[i][j] == matrixPole[i][j + 1] && matrixPole[i][j] == matrixPole[i][j + 2] && matrixPole[i][j] == matrixPole[i][j + 3] && matrixPole[i][j] == matrixPole[i][j + 4]) {
                    counter = counter + 20;
                }
            }
        }
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 10; i++) {
                if (matrixPole[i][j] == matrixPole[i + 1][j] && matrixPole[i][j] == matrixPole[i + 2][j] && matrixPole[i][j] == matrixPole[i + 3][j] || matrixPole[i][j] == matrixPole[i + 1][j] && matrixPole[i][j] == matrixPole[i + 2][j] && matrixPole[i][j] == matrixPole[i + 3][j] && matrixPole[i][j] == matrixPole[i + 4][j]) {
                    counter = counter + 20;
                }
            }
        }
        return counter;
    }
    public int getScore3() {
        int counter;
        counter = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrixPole[i][j] == matrixPole[i][j + 1] && matrixPole[i][j] == matrixPole[i][j + 2] && matrixPole[i][j] == matrixPole[i][j + 3] && matrixPole[i][j] == matrixPole[i][j + 4] && matrixPole[i][j] == matrixPole[i][j + 5]) {
                    counter = counter + 30;
                }
            }
        }
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 9; i++) {
                if (matrixPole[i][j] == matrixPole[i + 1][j] && matrixPole[i][j] == matrixPole[i + 2][j] && matrixPole[i][j] == matrixPole[i + 3][j] && matrixPole[i][j] == matrixPole[i + 4][j] && matrixPole[i][j] == matrixPole[i + 5][j]) {
                    counter = counter + 30;
                }
            }
        }
        return counter;
    }
    public boolean checkField() {
        boolean check = false;
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 13; j++) {
                if (matrixPole[i][j] == matrixPole[i + 1][j + 1] && matrixPole[i][j] == matrixPole[i][j + 2] || matrixPole[i+1][j] == matrixPole[i][j + 1] && matrixPole[i + 1][j] == matrixPole[i + 1][j + 2] || matrixPole[i][j] == matrixPole[i][j + 1] && matrixPole[i][j] == matrixPole[i + 1][j + 2] || matrixPole[i + 1][j] == matrixPole[i + 1][j + 1] && matrixPole[i + 1][j] == matrixPole[i][j + 2] || matrixPole[i + 1][j] == matrixPole[i][j + 1] && matrixPole[i + 1][j] == matrixPole[i][j + 2] || matrixPole[i][j] == matrixPole[i + 1][j + 1] && matrixPole[i][j] == matrixPole[i + 1][j + 2]) {
                    check = true;
                }
            }
        }
        for (int j = 0; j < 14; j++) {
            for (int i = 0; i < 13; i++) {
                if (matrixPole[i][j] == matrixPole[i + 1][j + 1] && matrixPole[i][j] == matrixPole[i + 2][j] || matrixPole[i][j + 1] == matrixPole[i + 1][j] && matrixPole[i][j + 1] == matrixPole[i + 2][j + 1] || matrixPole[i][j] == matrixPole[i + 1][j + 1] && matrixPole[i][j] == matrixPole[i + 2][j + 1] || matrixPole[i][j + 1] == matrixPole[i + 1][j] && matrixPole[i][j + 1] == matrixPole[i + 2][j] || matrixPole[i][j + 1] == matrixPole[i + 1][j + 1] && matrixPole[i][j + 1] == matrixPole[i + 2][j] || matrixPole[i][j] == matrixPole[i + 1][j] && matrixPole[i][j] == matrixPole[i + 2][j + 1]) {
                    check = true;
                }
            }
        }
        return check;
    }
    public void removeBalls() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (matrixPole[i][j] == matrixPole[i][j + 1] && matrixPole[i][j] == matrixPole[i][j + 2]){
                    matrixPole[i][j] = "_";
                    matrixPole[i][j + 1] = "_";
                    matrixPole[i][j + 2] = "_";
                }
            }
        }
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 13; i++) {
                if (matrixPole[i][j] == matrixPole[i + 1][j] && matrixPole[i][j] == matrixPole[i + 2][j]) {
                    matrixPole[i][j] = "_";
                    matrixPole[i + 1][j] = "_";
                    matrixPole[i + 2][j] = "_";
                }
            }
        }

    }
    public void replaceBalls() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (matrixPole[i][j] == "_") {
                    if (i == 0) {
                        matrixPole[i][j] = ball.getColor();
                    } else {
                        matrixPole[i][j] = matrixPole[i - 1][j];
                    }
                }
            }
        }
    }
    public void addBalls() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (matrixPole[i][j] == "_") {
                    matrixPole[i][j] = ball.getColor();
                }
            }
        }
    }
}






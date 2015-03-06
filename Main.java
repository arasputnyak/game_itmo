/**
 * Created by Владелец on 28.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Player player = new Player();
        field.fillPole();
        System.out.println(field + "\n");
        int count;
        count = 0;
        System.out.println("Текущий счет: " + count);
        while (field.checkField() == true) {
            player.makeStep();
            count = count + field.getScore3();
            count = count + field.getScore2();
            count = count + field.getScore1();
            field.removeBalls();
            field.replaceBalls();
            field.addBalls();
            System.out.println(field + "\n");
            System.out.println("Текущий счет: " + count);
            if (field.checkField() == false) {
                System.out.println("Возможных ходов нет, игра окончена.");
            }
        }





        /////
        Ball ball = new Ball();
        System.out.println(ball.getColor());
    }
}

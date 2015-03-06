import java.util.Scanner;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Player {
    Field field = new Field();
    public void makeStep() {
        field.changeMeaning();
    }
}

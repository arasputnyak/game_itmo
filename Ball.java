import java.util.Random;

/**
 * Created by Владелец on 28.02.2015.
 */
public class Ball {
    char color;
    public String getColor() {
        final String letter = "YRBGV";
        Random random = new Random();
        color = letter.charAt(random.nextInt(4));
        return String.valueOf(color);
    }
}

package ru.ifmo.rasputnyak;

/**
 * Created by Владелец on 20.03.2015.
 */
public class MakeStepCommand implements Command {
    private Player thePlayer;
    public MakeStepCommand(Player player) {
        this.thePlayer = player;
    }
    public void execute() {
        System.out.println("///");;
    }
}

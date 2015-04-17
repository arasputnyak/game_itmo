package ru.ifmo.rasputnyak;

/**
 * Created by Владелец on 20.03.2015.
 */
public class MakeStepCommand implements Command {
    private Player player;
    private Field field;
    public MakeStepCommand(Player player, Field field) {
        this.player = player;
        this.field = field;
    }
    public void execute() {
        player.makeStep(field);
    }
}

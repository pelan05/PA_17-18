package logicaJogo.events;
import java.io.Serializable;
import logicaJogo.*;
import java.util.ArrayList;


public class Event  implements Serializable{
    public int ActionPointAvaible;
    public String name;
    public String description;

    public ArrayList<EnemyAdvancement> EnemyAdvancementOrder;

    public int getActionPointAvaible() {
        return ActionPointAvaible;
    }

    public String getName() {
        return name;
    }

    public String getDescprition() {
        return description;
    }


    public void action(Game g){

    }

    public void ApplyEnemyAdvancementOrder(Game game) {
        EnemyAdvancementOrder.forEach((move) -> {move.action(game);});
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb  .append("----- ")
                .append(name).append(": ")
                .append(getActionPointAvaible())
                .append(" -----").append("\n")
                .append(description).append("\n");

        return sb.toString();
    }
}

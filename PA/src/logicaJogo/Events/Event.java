package logicaJogo.events;
import logicaJogo.*;
import java.util.ArrayList;


public class Event {
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
}

package logicaJogo.events;
import logicaJogo.*;
import java.util.ArrayList;


public class Event {
    public int ActionPointAvaible;
    public String name;
    public String descprition;

    public ArrayList<EnemyAdvancement> EnemyAdvancementOrder;

    public Event(int ActionPointAvaible, String name, String description){
        this.ActionPointAvaible = ActionPointAvaible;
        this.name = name;
        this.descprition = description;
        //this.EnemyAdvancementOrder
    }

    public int getActionPointAvaible() {
        return ActionPointAvaible;
    }

    public String getName() {
        return name;
    }

    public String getDescprition() {
        return descprition;
    }

    public void save(Game game){

    }

    public void ApplyEnemyAdvancementOrder(Game game) {
        EnemyAdvancementOrder.forEach((move) -> {move.save(game);});
    }
}

package logicaJogo.events;


import java.util.ArrayList;
import java.util.Arrays;

public class RegularMove extends Event {

    public RegularMove(String name, String description, int actionPoints, EnemyAdvancement ...ems) {
        this.name = name;
        this.description = description;
        this.ActionPointAvaible = actionPoints;

        this.EnemyAdvancementOrder = new ArrayList<>();
        this.EnemyAdvancementOrder.addAll(Arrays.asList(ems));
    }
}

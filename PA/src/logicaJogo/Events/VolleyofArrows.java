package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class VolleyofArrows extends RegularMove {
    public VolleyofArrows() {
        super("Volley Of Arrows", "+1 to all attacks", 3, new RamAdvancement());
    }

    @Override
    public void action(Game g){

    }
}

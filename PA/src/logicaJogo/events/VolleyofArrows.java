package logicaJogo.events;

import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

import java.io.Serializable;

public class VolleyofArrows extends RegularMove{
    public VolleyofArrows() {
        super("Volley Of Arrows", "+1 to all attacks", 3, new RamAdvancement());
    }

    @Override
    public void action(Game game){
        game.getDRM().put(DRM.RAM, 1);
        game.getDRM().put(DRM.TOWER, 1);
        game.getDRM().put(DRM.TREBUCHET, 1);
        game.getDRM().put(DRM.CIRCLE, 1);
        game.getDRM().put(DRM.CQB, 1);
    }
}

package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;


public class FlamingArrows extends RegularMove  implements Serializable{

    public FlamingArrows() {
        super("Flaming Arrows", "+1 to attacks on the Siege Engine", 3, new TowerAdvancement());
    }
    
    @Override
    public void action(Game game){
        game.getDRM().put(DRM.RAM, 1);
        game.getDRM().put(DRM.LADDERS, 1);
        game.getDRM().put(DRM.TOWER, 1);
    }
    
}

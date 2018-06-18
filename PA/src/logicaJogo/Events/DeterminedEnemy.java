package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class DeterminedEnemy extends RegularMove  implements Serializable{

    public DeterminedEnemy(){
    super("Determined Enemy", "-1 to attacks on the Battering Ram", 2, new RamAdvancement());
    }
    
    @Override
    public void action(Game game){
        game.getDRM().put(DRM.RAM, 1);
    }
}

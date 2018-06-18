package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class CoverofDarkness extends RegularMove  implements Serializable{

    public CoverofDarkness() {
        super("Cover of Darkness", "+1 to Raid and Sabotage actions", 3, new SlowestUnitAdvance());
    }

    @Override
    public void action(Game game){
        game.getDRM().put(DRM.RAID, 1);
        game.getDRM().put(DRM.SABOTAGE, 1);
    }
}

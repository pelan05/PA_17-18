package logicaJogo.events;

import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class GateFortified extends RegularMove {
    public GateFortified() {
        super("Gate Fortified", "+1 to attacks on the Battering Ram", 2, new LadderAdvancement(), new RamAdvancement());
    }

    @Override
    public void action(Game game){
        game.getDRM().put(DRM.RAM, 1);
    }


}

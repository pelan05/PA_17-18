package logicaJogo.events;

import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class IronShields extends RegularMove {
    public IronShields() {
        super("Iron Shields", "-1 to attacks on the Siege Tower", 2, new RamAdvancement());
    }

    @Override
    public void action(Game game){
        game.getDRM().put(DRM.TOWER, -1);
    }
}

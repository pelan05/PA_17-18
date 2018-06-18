package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class Rally extends RegularMove  implements Serializable{
    public Rally() {
        super("Rally", "+1 to attacks on Close combat or Circle Spaces", 3, new TowerAdvancement(), new RamAdvancement());
    }

    @Override
    public void action(Game game){
        game.getDRM().put(DRM.CQB, 1);
        game.getDRM().put(DRM.CIRCLE, 1);
    }
}

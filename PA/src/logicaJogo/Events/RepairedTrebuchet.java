package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class RepairedTrebuchet extends RegularMove  implements Serializable{
    public RepairedTrebuchet() {
        super("Repaired Trebuchet", "Add 1 trebuchet (max3) and +1 to coupure action", 2, new LadderAdvancement());
    }

    @Override
    public void action(Game game){
        game.getEnemy().increaseTrebuchet();
        game.getDRM().put(DRM.COUPURE, 1);
    }
}

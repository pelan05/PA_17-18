package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class Illness extends RegularMove  implements Serializable{
    public Illness() {
        super("Illness", "Reduce morale and supplies by 1", 2, new TowerAdvancement());
    }

    @Override
    public void action(Game game){
        game.getStatus().decreaseMorale();
        game.getStatus().decreaseSupplies();
    }
}

package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class SuppliesSpoiled extends RegularMove implements Serializable {
    
    public SuppliesSpoiled() {
        super("Supplies SPoiled", "Reduce supplies by 1", 2, new LadderAdvancement());
    }

    @Override
    public void action(Game game){
        game.getStatus().decreaseSupplies();
    }
    
}

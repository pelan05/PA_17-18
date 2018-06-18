package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;

import java.io.Serializable;

public class SuppliesSpoiled extends RegularMove {
    
    public SuppliesSpoiled() {
        super("Supplies SPoiled", "Reduce supplies by 1", 2, new LadderAdvancement());
    }

    @Override
    public void action(Game game){
        game.getStatus().decreaseSupplies();
    }
    
}

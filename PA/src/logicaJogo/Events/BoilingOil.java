package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class BoilingOil extends RegularMove {
    public BoilingOil() {
        super("Boiling Oil", "+2 to attacks on enemy units in circle spaces", 2, new LadderAdvancement(), new RamAdvancement());
    }

    @Override
    public void action(Game g){

    }
    
    
}

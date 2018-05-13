package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class GuardsDistracted extends RegularMove {
    
    public GuardsDistracted() {
        super("Guards Distracted", "+1 to sabotage action and morale action", 2, new SlowestUnitAdvance());
    }

    @Override
    public void action(Game g){

    }


}

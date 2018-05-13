package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class RepairedTrebuchet extends RegularMove {
    public RepairedTrebuchet() {
        super("Repaired Trebuchet", "Add 1 trebuchet (max3) and +1 to coupure action", 2, new LadderAdvancement());
    }

    @Override
    public void action(Game g){

    }
}

package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class Rally extends RegularMove {
    public Rally() {
        super("Rally", "+1 to attacks on Close combat or Circle Spaces", 3, new TowerAdvancement(), new RamAdvancement());
    }

    @Override
    public void action(Game g){

    }
}

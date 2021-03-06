package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class DeathofaLeader extends RegularMove {

    public DeathofaLeader() {
        super("Death Of A Leader", "Reduce morale by 1", 2, new LadderAdvancement(), new TowerAdvancement());
    
    }
    
    
    @Override
    public void action(Game game){
        game.getStatus().decreaseMorale();
    }
}

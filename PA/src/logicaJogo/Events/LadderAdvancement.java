package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.cartas.EnemyCard;

public class LadderAdvancement extends EnemyAdvancement {
    
    @Override
    public void action(Game g){
        EnemyCard carta = g.getEnemy();
        
        carta.advanceLadder();
        
    }
    
    
}


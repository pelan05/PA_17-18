package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.cartas.EnemyCard;

public class TowerAdvancement extends EnemyAdvancement {
    
    @Override
    public void action(Game g){
        EnemyCard carta = g.getEnemy();
        
        carta.advanceTower();
        
    }
    
}
package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.Game;
import logicaJogo.cartas.EnemyCard;


public class RamAdvancement extends EnemyAdvancement  implements Serializable{
    
    @Override
    public void action(Game g){
        EnemyCard carta = g.getEnemy();
        
        carta.advanceRams();
        
    }
    
}
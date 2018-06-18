package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.Game;
import logicaJogo.cartas.EnemyCard;

public class SlowestUnitAdvance extends EnemyAdvancement  implements Serializable{
    
    @Override
    public void action(Game g){
        
        EnemyCard carta = g.getEnemy();
        
        Integer []valores = new Integer[3];
        boolean done = false;
        
        valores[0] = carta.getLadders();
        valores[1] = carta.getRams();
        valores[2] = carta.getTower();
                
        int max = 0;
        for(int i = 0; i< 3; i++)
            max = Math.max(max, valores[i]);
        
        for (int i = 0; i < 3; i++) {
            if (valores.equals(max) && done == false) {
                switch(i){
                    case 1:
                        carta.advanceLadder();
                        done = true;
                        break;
                    case 2:
                        carta.advanceRams();
                        done = true;
                        break;
                    case 3:
                        carta.advanceTower();
                        done = true;
                        break;
                
                }
            }
        }
        
        
        
    }
    
}

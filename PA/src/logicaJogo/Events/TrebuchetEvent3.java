package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.cartas.StatusCard;
import logicaJogo.events.RegularMove;

public class TrebuchetEvent3 extends RegularMove {
    public TrebuchetEvent3() {
        
        /*switch(g.getDay())*/
        
        super("Trebuchet Attack", "2 Damage to wall, 1 Damage to wall, 1 Damage to wall on D6 roll of 4, 5 or 6", 1, new NoEnemyAdvancement());
    
    
    
    }

    @Override
    public void action(Game g){
            
        
        
    StatusCard card = g.getStatus();
    int trebuchets = g.getEnemy().getTrebuchets();
        
    switch (trebuchets) {
        case 3:
            card.decreaseWall();
            card.decreaseWall();
            break;
        case 2:
            card.decreaseWall();
            break;
        case 1:
            int roll = g.getRoll();
            if (roll >= 4)
                card.decreaseWall();
            break;

        default:
            break;
        }
    }        
        
        
    
}

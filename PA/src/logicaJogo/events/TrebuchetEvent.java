package logicaJogo.events;

import logicaJogo.cartas.*;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class TrebuchetEvent extends RegularMove {
    public TrebuchetEvent() {
        
        /*switch(g.getDay())*/
        
        super("Trebuchet Attack", "2 Damage to wall, 1 Damage to wall, 1 Damage to wall on D6 roll of 4, 5 or 6", 3, new NoEnemyAdvancement());
    
    
    
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

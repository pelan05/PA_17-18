package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class Collapsed extends RegularMove  implements Serializable{
    
    public Collapsed(){
        super("Collapsed!", "Siege Tower removed from game if on starting space", 2, new LadderAdvancement(), new RamAdvancement());
    }

    @Override
    public void action(Game game){
        game.getEnemy().removeTower();
    }
    
}

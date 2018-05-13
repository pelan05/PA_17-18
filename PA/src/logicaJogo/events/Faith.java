package logicaJogo.events;
import logicaJogo.events.RegularMove;
import logicaJogo.Game;

public class Faith extends RegularMove {

    public Faith(){
        super("Faith", "+1 to attacks on the Battering Ram, Ladders and Morale Action", 3, new LadderAdvancement(), new RamAdvancement(), new TowerAdvancement());
    }
    
    @Override
    public void action(Game g){

    }
    
}

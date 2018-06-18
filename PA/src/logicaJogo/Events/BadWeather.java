package logicaJogo.events;

import java.io.Serializable;
import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class BadWeather extends RegularMove  implements Serializable{
    
public BadWeather() {
    super("Bad Weather", "Only raid and sabotage actions allowed this turn", 2, new NoEnemyAdvancement());
}

@Override
    public void action(Game game){
        game.setRaidSabotageOnly();
    }
}

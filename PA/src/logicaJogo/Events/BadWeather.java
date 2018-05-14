package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;

public class BadWeather extends RegularMove {
    
public BadWeather() {
    super("Bad Weather", "Only raid and sabotage actions allowed this turn", 2, new NoEnemyAdvancement());
}

@Override
    public void action(Game game){
        game.setRaidSabotageOnly();
    }
}

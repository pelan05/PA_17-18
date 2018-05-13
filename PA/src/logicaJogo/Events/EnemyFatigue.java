package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.events.RegularMove;


public class EnemyFatigue extends RegularMove {

    public EnemyFatigue() {
        super("Enemy Fatigue", "+1 to Coupure, Raid adn Sabotage actions", 3, new LadderAdvancement());   
    }

    @Override
    public void action(Game g){

    }


}
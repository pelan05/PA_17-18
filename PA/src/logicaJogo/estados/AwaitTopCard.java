package logicaJogo.estados;

import logicaJogo.Game;
import logicaJogo.cartas.EventCard;
import logicaJogo.events.Event;

public class AwaitTopCard extends StateAdapter {
    public AwaitTopCard(Game game){
        super(game);
    }

    @Override
    public Estado drawsTopCard(){
        EventCard card = game.drawCard();
        game.addInfo("Drawn Card: " + card.toString());

        Event currentEvent = card.getEvent(game.getDay());
        game.addInfo("Applied Event: " + currentEvent.toString());

        // add action points
        //game.addAP(currentEvent.getActionPointAllowance());

        // Event Phase
        currentEvent.action(game);

        // Enemy Movement Phase
        //currentEvent.applyEnemyMovement(game);

        // check if there are 3 enemies in CCA => loose
        if (game.getEnemy().checkCCA() == 3) {
            return new GameOver(game);
        }

        return new AwaitPlayerAction(getGame());
    }
}

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
        game.addInfo("Drawn Card: " + card.toString() + "\n");
        
        Event currentEvent = card.getEvent(game.getDay());
        game.addInfo("Applied Event: " + currentEvent.toString() + "\n");

        game.getActionPoints();
        
        currentEvent.action(game);
        
        currentEvent.ApplyEnemyAdvancementOrder(game);
        
        if (game.getEnemy().checkCCA() == 3) {
            return new GameOver(game);
        }
        
        return new AwaitPlayerAction(getGame());
    }
}

package logicaJogo.estados;

import logicaJogo.Game;
import logicaJogo.ObservableGame;

public class AwaitBeggining extends StateAdapter {

    public AwaitBeggining(Game game){
        super(game);
    }

    @Override
    public Estado Beggining(){
        if(getGame() == null){
        getGame().CreateDeck();
        getGame().ShuffleDeck();
        getGame().newTurn();
        return new AwaitTopCard(getGame());
        }
        else
            return new AwaitPlayerAction(getGame());
    }
}

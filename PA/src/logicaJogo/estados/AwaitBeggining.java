package logicaJogo.estados;

import logicaJogo.Game;
import logicaJogo.ObservavleGame;

public class AwaitBeggining extends StateAdapter {

    public AwaitBeggining(Game game){
        super(game);
    }

    @Override
    public Estado Beggining(){
        getGame().CreateDeck();
        getGame().ShuffleDeck();
        getGame().newTurn();
        return new AwaitTopCard(getGame());
    }
}

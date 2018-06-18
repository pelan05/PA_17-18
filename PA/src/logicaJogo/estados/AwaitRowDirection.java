package logicaJogo.estados;

import logicaJogo.Game;

public class AwaitRowDirection extends StateAdapter {

    public AwaitRowDirection(Game game){
        super(game);
    }

    @Override
    public Estado selectRow(int row) {
        getGame().setRowChoice(row);

        return new AwaitPlayerAction(getGame());
    }
}

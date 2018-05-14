package logicaJogo.estados;

import logicaJogo.Game;
import logicaJogo.ObservableGame;
import logicaJogo.cartas.row;

public class StateAdapter implements Estado {

    public Game game;

    public StateAdapter(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public Estado drawsTopCard() {return this;}

    @Override
    public Estado Beggining(){return this;}

    @Override
    public Estado selectRow(int row){return this;}
    
    @Override
    public Estado archersAttack() {return this;}

    @Override
    public Estado boilingWater() {return this;}

    @Override
    public Estado rallyTroops(boolean appDRM) {return this;}

    @Override
    public Estado closeCombat() {return this;}

    @Override
    public Estado coupure() {return this;}

    @Override
    public Estado supplyRaid() {return this;}

    @Override
    public Estado sabotage(int DRMval) {return this;}
    
    @Override
    public Estado tunnelMovement() {return this;}

    @Override
    public Estado paidTunnelMovement() {return this;}

    @Override
    public Estado exitTunnel(){return this;}

    @Override
    public Estado enterTunnel(){return this;}

    @Override
    public Estado GameResult(){return this;}

    @Override
    public Estado endOfTurn(){return this;}
}

package logicaJogo.estados;

import logicaJogo.Game;
import logicaJogo.ObservavleGame;
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
    public Estado endOfActions() {return this;}

    @Override
    public Estado Beggining(){return this;}

    //-------------------------------------------------

    @Override
    public Estado archersAttack() {return this;}

    @Override
    public Estado boilingWater() {return this;}


    @Override
    public Estado rallyTroops() {return this;}

    @Override
    public Estado closeCombat() {return this;}

    @Override
    public Estado coupure() {return this;}

    @Override
    public Estado supplyRaid() {return this;}

    @Override
    public Estado sabotage(int DRM) {return this;}

    //-----------------------------------------------

    @Override
    public Estado tunnelMovement() {return this;}

    @Override
    public Estado freeTunnelMovement() {return this;}

    @Override
    public Estado paidTunnelMovement() {return this;}

    //--------------------------------------------------

    @Override
    public Estado GameResult(){return this;}
}

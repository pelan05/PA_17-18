package logicaJogo;

import logicaJogo.estados.AwaitBeggining;
import logicaJogo.estados.Estado;

import java.util.ArrayList;

public class ObservavleGame {
    private Game game;
    private Estado state;

    public ObservavleGame() {
        this.game = new Game();
        this.state = new AwaitBeggining(game);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Estado getState() {
        return state;
    }

    public void setState(Estado state) {
        this.state = state;
    }

    public ArrayList<String> getInfo() {
        return game.getInfo();
    }

    public void clearInfo() {
        game.clearInfo();
    }

    @Override
    public String toString() {
        return game.toString();
    }

    // -------- State methods --------
    public void start() {
        setState(getState().Beggining());
    }

    public void draw() {
        setState(getState().drawsTopCard());
    }


    // -------- Player Action methods ------

    public void archersAttack() {
        setState(getState().archersAttack());
    }

    public void boilingWaterAttack() {
        setState(getState().boilingWater());
    }

    public void closeCombat() {
        setState(getState().closeCombat());
    }

    public void coupure() {
        setState(getState().coupure());
    }

    public void rallyTroops(Boolean applyDRM) {
        setState(getState().rallyTroops());
    }

    public void supplyRaid() {
        setState(getState().supplyRaid());
    }

    public void sabotage() {
        setState(getState().sabotage(0));
    }

    public void endTurn() {
        setState(getState().endOfActions());
    }

    public void tunnelMovement() {
        setState(getState().tunnelMovement());
    }

    // ------- Tunnel Movement methods ---------

    public void enterTunnel() {
        setState(getState().enterTunnel());
    }

    public void exitTunnel() {
        setState(getState().tunnelMovement());
    }

    public void advanceTunnel() {
        setState(getState().advanceTunnel());
    }

    public void fastMovement() {
        setState(getState().paidTunnelMovement());
    }

    public void selectTrack(int track) {
        setState(getState().selectTrack(track));
    }
}

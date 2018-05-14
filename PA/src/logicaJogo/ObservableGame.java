package logicaJogo;

import logicaJogo.estados.AwaitBeggining;
import logicaJogo.estados.Estado;

import java.util.ArrayList;

public class ObservableGame {
    private Game game;
    private Estado state;

    public ObservableGame() {
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

    public void start() {
        setState(getState().Beggining());
    }

    public void draw() {
        setState(getState().drawsTopCard());
    }

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
        setState(getState().rallyTroops(applyDRM));
    }

    public void supplyRaid() {
        setState(getState().supplyRaid());
    }

    public void sabotage() {
        setState(getState().sabotage(0));
    }

    public void endOfTurn() {
        setState(getState().endOfTurn());
    }

    public void tunnelMovement() {
        setState(getState().tunnelMovement());
    }

    public void enterTunnel() {
        setState(getState().enterTunnel());
    }

    public void exitTunnel() {
        setState(getState().exitTunnel());
    }

    public void fastMovement() {
        setState(getState().paidTunnelMovement());
    }

    public void selectRowChoice(int row) {
        setState(getState().selectRow(row));
    }

    @Override
    public String toString() {
        return game.toString();
    }
}

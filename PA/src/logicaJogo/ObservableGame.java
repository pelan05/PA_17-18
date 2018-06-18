package logicaJogo;

import logicaJogo.estados.AwaitBeggining;
import logicaJogo.estados.Estado;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Observable;

public class ObservableGame extends Observable {
    private Game game;
    private Estado state;

    public ObservableGame() {
        this.game = new Game();
        this.state = new AwaitBeggining(game);
        setChanged();
        notifyObservers();
    }

    private void loadGameInstance(){
        Game aux = game ;
        try {

            FileInputStream fi = new FileInputStream("game.bin");
            ObjectInputStream oi = new ObjectInputStream(fi);
            aux = ((Game) oi.readObject());
            oi.close();
            game = aux;
            start();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error on reading file "+ e);
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("File game.bin: " + e);
        }

    }

    private void saveGameInstance(){
        try{
            FileOutputStream fo = new FileOutputStream("game.bin");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(game);
            oo.close();
        }catch(IOException e){
            System.out.println("Error on saving in object file " + e);
        }
    }

    public void loadGame(){
        loadGameInstance();

        setChanged();
        notifyObservers();
    }

    public void saveGame(){
        saveGameInstance();

        setChanged();
        notifyObservers();
    }

    public void setGame(Game game) {
        this.game = game;
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }

    public void draw() {
        setState(getState().drawsTopCard());
        setChanged();
        notifyObservers();
    }

    public void archersAttack() {
        setState(getState().archersAttack());
        setChanged();
        notifyObservers();
    }

    public void boilingWaterAttack() {
        setState(getState().boilingWater());
        setChanged();
        notifyObservers();
    }

    public void closeCombat() {
        setState(getState().closeCombat());
        setChanged();
        notifyObservers();
    }

    public void coupure() {
        setState(getState().coupure());
        setChanged();
        notifyObservers();
    }

    public void rallyTroops(Boolean applyDRM) {
        setState(getState().rallyTroops(applyDRM));
        setChanged();
        notifyObservers();
    }

    public void supplyRaid() {
        setState(getState().supplyRaid());
        setChanged();
        notifyObservers();
    }

    public void sabotage() {
        setState(getState().sabotage(0));
        setChanged();
        notifyObservers();
    }

    public void endOfTurn() {
        setState(getState().endOfTurn());

    }

    public void tunnelMovement() {
        setState(getState().tunnelMovement());
        setChanged();
        notifyObservers();
    }

    public void enterTunnel() {
        setState(getState().enterTunnel());
        setChanged();
        notifyObservers();
    }

    public void exitTunnel() {
        setState(getState().exitTunnel());
        setChanged();
        notifyObservers();
    }

    public void fastMovement() {
        setState(getState().paidTunnelMovement());
        setChanged();
        notifyObservers();
    }

    public void selectRowChoice(int row) {
        
        setState(getState().selectRow(row));
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return game.toString();
    }

}

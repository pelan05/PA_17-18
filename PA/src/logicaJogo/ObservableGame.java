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
    }

    private void loadGameInstance(){
        Game aux = game ;
        try {

            FileInputStream fi = new FileInputStream("game.bin");
            ObjectInputStream oi = new ObjectInputStream(fi);
            aux = ((Game) oi.readObject());
            oi.close();
            game = aux;
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
    public boolean isUsed(int index){
        return  game.cardIsUsed(index);
    }

    public Boolean isTurned(int index){
        return game.getCard(index).isTurned();
    }

    public void chooseCard(int pos){
        draw();

        setChanged();
        notifyObservers();


        if(pos == 0 || pos == 3){
            getGame().getCard(pos + 1).turnCard();
            getGame().getCard(pos + 2).turnCard();
        }else if( pos == 1 ) {
            getGame().getCard(pos + 1).useCard();
            getGame().getCard(pos + 2).turnCard();
        }else if (pos == 2 ) {
            getGame().getCard(pos - 1).useCard();
            getGame().getCard(pos + 1).turnCard();
        }else if (pos == 4) {
            getGame().getCard(pos + 1).useCard();
        }else if(pos == 5) {
            getGame().getCard(pos - 1).useCard();
        }

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return game.toString();
    }

    public int getDeckSize(){
        return game.getDeckSize();
    }

    public final ImageIcon getCardImage(int index){
        return game.getCardImg(index);
    }
}

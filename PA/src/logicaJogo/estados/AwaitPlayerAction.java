package logicaJogo.estados;

import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.cartas.row;

import java.util.ArrayList;

public class AwaitPlayerAction extends StateAdapter {
    public AwaitPlayerAction(Game game){
        super(game);
    }

    @Override
    public  Estado archersAttack(){
        row ROW = getGame().getEnemy().getRow(getGame().getRowChoice());

        int diceRoll = getGame().getRoll();

        switch(getGame().getRowChoice()){
            case 0:
                diceRoll += getGame().getDRM().get(DRM.LADDERS);
                break;
            case 1:
                diceRoll += getGame().getDRM().get(DRM.RAM);
                break;
            case 2:
                diceRoll += getGame().getDRM().get(DRM.TOWER);
                break;
        }

        if(getGame().getEnemy().inCircleSpace(ROW) == 1)
            diceRoll +=  getGame().getDRM().get(DRM.CIRCLE);

        getGame().addInfo("Dice Roll: " + diceRoll);

        if(diceRoll > ROW.getStrength())
            ROW.setValueUp();

            return this;
    }

    @Override
    public Estado boilingWater(){
        row ROW = getGame().getEnemy().getRow(getGame().getRowChoice());

        int diceRoll = getGame().getRoll();
        
        if (getGame().getEnemy().inCircleSpace(ROW) != 1)
            return this;

        switch(getGame().getRowChoice()){
            case 0:
                diceRoll += getGame().getDRM().get(DRM.LADDERS);
                break;
            case 1:
                diceRoll += getGame().getDRM().get(DRM.RAM);
                break;
            case 2:
                diceRoll += getGame().getDRM().get(DRM.TOWER);
                break;
        }

        if(getGame().getEnemy().inCircleSpace(ROW) == 1)
            diceRoll +=  getGame().getDRM().get(DRM.CIRCLE);

        getGame().addInfo("Dice Roll: " + diceRoll);

        
        if(diceRoll == 1)
            return this;

        getGame().addInfo("Roll: " + (diceRoll+1));
        if ((diceRoll + 1) > ROW.getStrength())
            ROW.setValueUp();

            return this;
    }

    @Override
    public Estado coupure(){
        int roll = getGame().getRoll() + getGame().getDRM().get(DRM.COUPURE);

        if (roll > 4)
            getGame().getStatus().increaseWall();

            return this;
    }

    @Override
    public Estado supplyRaid(){

        if (getGame().getStatus().getSupplies() == 2)
            return this;

        if (getGame().getStatus().getTunnel() != 3)
            return this;

        int roll = getGame().getRoll() + getGame().getDRM().get(DRM.RAID);

        if (roll == 6) {
            getGame().getStatus().increaseSupplies();
            getGame().getStatus().increaseSupplies();

        } else if (2 < roll && roll < 6) {
            getGame().getStatus().increaseSupplies();

        } else if (roll == 1) {
            getGame().capture();
        }


            return this;
    }

    @Override
    public Estado sabotage(int DRMval){

        if (getGame().getStatus().getTunnel() != 3)
            return this;

        int roll = getGame().getRoll() + getGame().getDRM().get(DRM.SABOTAGE);

        if (roll == 1)
            getGame().capture();

        else if (roll > 4)
            getGame().getEnemy().decreaseTrebuchet();

            return this;
    }

    @Override
    public Estado rallyTroops(boolean appDRM){
        int roll = 0;

        if (appDRM) {
            getGame().getStatus().getSupplies();
            roll = getGame().getDRM().get(DRM.MORALE);
        }

        roll += getGame().getRoll();

        if (roll > 4)
            getGame().getStatus().increaseMorale();

            return this;
    }

    @Override
    public Estado closeCombat(){
        ArrayList<row> rows = new ArrayList<>();

        if (getGame().getEnemy().getLadders() == 0)
            rows.add(getGame().getEnemy().getRow(0));

        if (getGame().getEnemy().getRams() == 0)
            rows.add(getGame().getEnemy().getRow(1));

        if (getGame().getEnemy().getTower() == 0)
            rows.add(getGame().getEnemy().getRow(2));



        for (row ROW: rows) {
            int roll = getGame().getRoll();

            if (roll == 1)
                getGame().getStatus().decreaseMorale();

            roll += getGame().getDRM().get(DRM.CQB);

            getGame().addInfo("Roll: " + roll);
            if (roll > ROW.getStrength())
                ROW.setValueDown();
        }
            return this;
    }

    @Override
    public Estado endOfTurn() {

        if (getGame().getGameResult()) {
            return new GameOver(getGame());
        }

        if (getGame().DeckEmpty())
            getGame().endOfDay();

        if (getGame().getDay() == 3)
            return new GameOver(getGame());

        getGame().newTurn();
        return new AwaitTopCard(getGame());
    }

    @Override
    public Estado tunnelMovement() {
        return new AwaitTunnelChoice(getGame());
    }
}

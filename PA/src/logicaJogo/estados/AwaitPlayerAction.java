package logicaJogo.estados;

import logicaJogo.DRM;
import logicaJogo.Game;
import logicaJogo.cartas.row;

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
            ROW.setValueDown();

        return this;
    }

    @Override
    public Estado boilingWater(){
        return this;
    }

    @Override
    public Estado coupure(){
        return this;
    }

    @Override
    public Estado supplyRaid(){
        return this;
    }

    @Override
    public Estado sabotage(int DRM){
        return this;
    }

    @Override
    public Estado rallyTroops(){
        return this;
    }

    @Override
    public Estado closeCombat(){
        return this;
    }
}

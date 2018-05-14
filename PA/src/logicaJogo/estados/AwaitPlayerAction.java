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
        int diceRoll = getGame().getRoll() + getGame().getDRM().get(DRM.COUPURE);
        
        if(diceRoll > 4)
             getGame().getStatus().increaseWall();
        
        return this;
    }

    @Override
    public Estado supplyRaid(){
        //if carried supplies are max already
        if(getGame().getStatus().getExtraSupplies().getValue() == 2)
            return this;
        //if soldiers are not on enemy lines(val== 3)
        if(getGame().getStatus().getTunnel() != 3)
            return this;
        
        int diceRoll = getGame().getRoll() + getGame().getDRM().get(DRM.RAID);
        
        if(diceRoll == 6){//6 = 2 extra
            getGame().getStatus().getExtraSupplies().setValueUp();
            getGame().getStatus().getExtraSupplies().setValueUp();
        }
        
        if(diceRoll < 6 && diceRoll > 2){//3,4,5 = 1 extra
            getGame().getStatus().getExtraSupplies().setValueUp();
        }
        
        if(diceRoll == 1){getGame().capture();}//1 = captured
        
        
        return this;
    }

    @Override
    public Estado sabotage(){
        //check enemy lines
        if(getGame().getStatus().getTunnel() != 3)
            return this;
        
        int diceRoll = getGame().getRoll() + getGame().getDRM().get(DRM.SABOTAGE);
        
        if(diceRoll == 1)//captured
            getGame().capture();
        
        if(diceRoll > 4)//sabotage successful
            getGame().getEnemy().removeTrebuchet();
        
        
        return this;
    }

    @Override
    public Estado rallyTroops(boolean supplies){
        int diceRoll = 0;
        
        if(supplies){//if the user spends supplies to get drm
            getGame().getStatus().decreaseSupplies();
            diceRoll = getGame().getDRM().get(DRM.MORALE);            
        }
        
        diceRoll += getGame().getRoll();
    
        if (diceRoll > 4)
            getGame().getStatus().increaseMorale();
        
        return this;
    }

    @Override
    public Estado closeCombat(){
        
        if(getGame().getEnemy().getLadders() == 0){
            int diceRoll = getGame().getRoll() + getGame().getDRM().get(DRM.CQB);
            
            if(diceRoll == 1)
                getGame().getStatus().decreaseMorale();
            
            getGame().addInfo("Roll: " + diceRoll);
            if (diceRoll > getGame().getEnemy().getLadderStrength())
                getGame().getEnemy().getRow(1).setValueUp();
        
        }
        
        if(getGame().getEnemy().getRams() == 0){
            int diceRoll = getGame().getRoll() + getGame().getDRM().get(DRM.CQB);
        
            if(diceRoll == 1)
                getGame().getStatus().decreaseMorale();
            
            getGame().addInfo("Roll: " + diceRoll);
            if (diceRoll > getGame().getEnemy().getRamStrength())
                getGame().getEnemy().getRow(2).setValueUp();
        }
        
        if(getGame().getEnemy().getTower() == 0){
            int diceRoll = getGame().getRoll() + getGame().getDRM().get(DRM.CQB);
        
            if(diceRoll == 1)
                getGame().getStatus().decreaseMorale();
            
            getGame().addInfo("Roll: " + diceRoll);
            if (diceRoll > getGame().getEnemy().getTowerStrength())
                getGame().getEnemy().getRow(3).setValueUp();
        }
        
        
        return this;
    }
}

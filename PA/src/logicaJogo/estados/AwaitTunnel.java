package logicaJogo.estados;
import java.util.*;
import logicaJogo.*;


public class AwaitTunnel implements Estado{

    @Override
    public Estado drawsTopCard() {return this;}

    @Override
    public Estado endOfActions() {return this;}

    @Override
    public Estado winGame() {return this;}

    @Override
    public Estado loseGame() {
        
        //lose the game
        
        return this;
    }

    @Override
    public Estado archersAttack() {return this;}

    @Override
    public Estado endArchersAttack() {return this;}

    @Override
    public Estado boilingWater() {return this;}

    @Override
    public Estado endBoilingWater() {return this;}

    @Override
    public Estado tunnelMovement() {return this;}

    
    
    @Override
    public Estado freeTunnelMovement() {
        
        return new AwaitPlayerAction();
        
    }

    @Override
    public Estado paidTunnelMovement() {
        /*if(player.getActonPoints() == 0)
            return this;
        else{
            player.reduceActionPoints();
            return new AwaitPlayerAction();
        }
        */
        return this;//remover<------------------
    }

     
    
    
    @Override
    public Estado rallyTroops() {return this;}

    @Override
    public Estado endRallyTroops() {return this;}

    @Override
    public Estado closeCombat() {return this;}

    @Override
    public Estado coupure() {return this;}

    @Override
    public Estado supplyRaid() {return this;}

    @Override
    public Estado sabotage() {return this;}
    
}
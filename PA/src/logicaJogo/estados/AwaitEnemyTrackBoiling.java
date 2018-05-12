package logicaJogo.estados;
import java.util.*;
import logicaJogo.*;



public class AwaitEnemyTrackBoiling implements Estado{

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
    public Estado endArchersAttack() {
    
        return new AwaitPlayerAction();
    
    }

    @Override
    public Estado boilingWater() {return this;}

    @Override
    public Estado endBoilingWater() {return this;}

    @Override
    public Estado tunnelMovement() {return this;}

    @Override
    public Estado freeTunnelMovement() {return this;}

    @Override
    public Estado paidTunnelMovement() {return this;}

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

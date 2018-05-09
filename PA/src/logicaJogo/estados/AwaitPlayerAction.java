package logicaJogo.estados;
import java.util.*;
import logicaJogo.*;


public class AwaitPlayerAction implements Estado{

    @Override
    public Estado drawsTopCard() {return this;}

    @Override
    public Estado endOfActions() {
    
        return new AwaitTopCard();
    
    }

    @Override
    public Estado winGame() {
    
    //end the game
    return this;
    }

    @Override
    public Estado loseGame() {
        
        //lose the game
        
        return this;
    }

    @Override
    public Estado archersAttack() {
    
        return new AwaitEnemyTrackArchers();
    
    }

    @Override
    public Estado endArchersAttack() {return this;}

    @Override
    public Estado boilingWater() {
    
        return new AwaitEnemyTrackBoiling();
    
    }

    @Override
    public Estado endBoilingWater() {return this;}

    @Override
    public Estado tunnelMovement() {
    
        return new AwaitTunnel();
        
    }

    @Override
    public Estado freeTunnelMovement() {return this;}

    @Override
    public Estado paidTunnelMovement() {return this;}

    @Override
    public Estado rallyTroops() {
    
        return new AwaitSuppliesBoost();
        
    }

    @Override
    public Estado endRallyTroops() {return this;}

    @Override
    public Estado closeCombat() {
    
        return new AwaitPlayerAction();
    
    }

    @Override
    public Estado coupure() {
    
        return new AwaitPlayerAction();
    
    }

    @Override
    public Estado supplyRaid() {
    
        return new AwaitPlayerAction();
    
    }

    @Override
    public Estado sabotage() {
    
        return new AwaitPlayerAction();
    
    }
    
}

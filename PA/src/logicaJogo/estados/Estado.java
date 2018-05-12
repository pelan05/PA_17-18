package logicaJogo.estados;
import java.util.*;
import logicaJogo.*;


public interface Estado {
    //17 metodos
    //1
    public Estado drawsTopCard();
    //2
    public Estado endOfActions();
    //3
    public Estado winGame();
    //4
    public Estado loseGame();
    //5
    public Estado archersAttack();
    //6
    public Estado endArchersAttack();
    //7
    public Estado boilingWater();
    //8
    public Estado endBoilingWater();
    //9
    public Estado tunnelMovement();
    //10
    public Estado freeTunnelMovement();
    //11
    public Estado paidTunnelMovement();
    //12
    public Estado rallyTroops();
    //13
    public Estado endRallyTroops();
    //14
    public Estado closeCombat();
    //15
    public Estado coupure();
    //16
    public Estado supplyRaid();
    //17
    public Estado sabotage();
    
}
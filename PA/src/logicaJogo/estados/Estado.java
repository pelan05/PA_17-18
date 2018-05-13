package logicaJogo.estados;

import logicaJogo.cartas.row;

public interface Estado {
    Estado drawsTopCard();
    Estado endOfActions();
    Estado Beggining();

    Estado GameResult();

    Estado archersAttack();
    Estado boilingWater();
    Estado coupure();
    Estado supplyRaid();
    Estado sabotage(int DRM);
    Estado rallyTroops();
    Estado closeCombat();

    Estado freeTunnelMovement();
    Estado paidTunnelMovement();
    Estado tunnelMovement();


}
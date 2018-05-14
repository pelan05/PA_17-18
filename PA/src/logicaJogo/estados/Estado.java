package logicaJogo.estados;

import logicaJogo.cartas.row;

public interface Estado {
    Estado drawsTopCard();
    Estado endOfActions();
    Estado Beggining();

    Estado selectRow(int row);
    Estado GameResult();

    Estado archersAttack();
    Estado boilingWater();
    Estado coupure();
    Estado supplyRaid();
    Estado sabotage();
    Estado rallyTroops(boolean supplies);
    Estado closeCombat();

    Estado enterTunnel();
    Estado exitTunnel();
    Estado paidTunnelMovement();
    Estado tunnelMovement();


}
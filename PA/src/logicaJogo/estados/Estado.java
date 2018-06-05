package logicaJogo.estados;

import java.io.Serializable;
import logicaJogo.cartas.row;

public interface Estado extends Serializable {
    Estado drawsTopCard();
    Estado Beggining();
    Estado endOfTurn();

    Estado selectRow(int row);
    Estado GameResult();

    Estado archersAttack();
    Estado boilingWater();
    Estado coupure();
    Estado supplyRaid();
    Estado sabotage(int DRMval);
    Estado rallyTroops(boolean DRM);
    Estado closeCombat();

    Estado enterTunnel();
    Estado exitTunnel();
    Estado paidTunnelMovement();
    Estado tunnelMovement();


}
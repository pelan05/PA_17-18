package logicaJogo.estados;
import java.util.*;
import logicaJogo.*;


public interface Estado {
    
    Estado AwaitTopCard();
    Estado AwaitPlayerAction();
    Estado AwaitBeginning();
    Estado AwaitEnemyTrackArchers();
    Estado AwaitEnemyTrackBoiling();
    Estado AwaitTunnel();
    Estado AwaitSuppliesBoost();
    
}
package logicaJogo.events;
import logicaJogo.*;

import java.io.Serializable;

public abstract class EnemyAdvancement  implements Serializable {
    public abstract void action(Game g);
}

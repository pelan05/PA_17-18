package logicaJogo.events;

import logicaJogo.Game;
import logicaJogo.cartas.*;

enum RowName{
    RAMS, LADDERS, TOWER;
}

public class Advance extends EnemyAdvancement {
    private RowName name;

    public Advance(RowName name){
        super();

        this.name = name;
    }

    @Override
    public void save(Game game){
        EnemyCard aux = game.getEnemyCard();//metodo nao existe

        switch (name){
            case RAMS: aux.advanceRams();
            case TOWER: aux.advanceTower();
            case LADDERS: aux.advanceLadder();
        }
    }
}

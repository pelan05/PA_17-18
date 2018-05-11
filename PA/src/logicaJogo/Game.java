package logicaJogo;

import java.util.*;
import logicaJogo.*;
import logicaJogo.cartas.*;
import logicaJogo.estados.*;


public class Game{
    protected int actionPoints;
    protected Card enemy;
    protected Card status;
    protected ArrayList <EventCard> arr = new ArrayList <EventCard>();
    
    
    Game(){
    this.enemy = new EnemyCard();
    this.status = new StatusCard();
        for (int i = 0; i < 7 ; i++) {
            arr.add(new EventCard());
        }
    
        
        
    }
    
    
    
}

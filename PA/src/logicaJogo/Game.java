package logicaJogo;

import java.util.*;
import logicaJogo.*;
import logicaJogo.cartas.*;
import logicaJogo.estados.*;


public class Game{
    protected int actionPoints;
    protected int day;
    protected Card enemy;
    protected Card status;
    protected ArrayList <EventCard> arr = new ArrayList <EventCard>();
    
    
    Game(){
    this.enemy = new EnemyCard();
    this.status = new StatusCard();
        for (int i = 0; i < 7 ; i++) {
            this.arr.add(new EventCard());
        }
    this.actionPoints = 0;
    this.day = 0;
    }
    
    public void setActionPoints(int ap){
        this.actionPoints = ap;
    }
    
    public int getActionPoints(){
        return this.actionPoints;
    }
    
    public int getDay(){
        return this.day;
    }
    
    public void addDay(){
        this.day++;
    }
    
    
    
    
    
}

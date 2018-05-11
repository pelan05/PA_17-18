package logicaJogo;

import logicaJogo.events.Event;
import logicaJogo.cartas.EnemyCard;
import logicaJogo.cartas.EventCard;
import logicaJogo.cartas.StatusCard;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
	private int actionPoints;
	private int day;
	
    private DiceRoll dice;

    private StatusCard status;
    private EnemyCard enemy;

    private ArrayList<EventCard> deck;

    Game(){
        this.dice = new DiceRoll();
        this.status = new StatusCard();
        this.enemy = new EnemyCard();
		this.actionPoints = 0;
		this.day = 0;
		/*
		for (int i = 0; i < 7 ; i++) {
            this.deck.add(new EventCard());
        }
		*/
		
    }

    public void CreateDeck(){
        Event eg[] = null;
        Freader read = new Freader();
        String file = "Card1.txt";
        deck.clear();


        for (int i = 0; i < 7; i++) {
            read.ReadFile(file, eg);
            deck.add(new EventCard( i+1, eg[0], eg[1], eg[2]));
            file = "Card" + (Integer.parseInt(file.substring(1,file.length()))+1) + ".txt";
        }

        ShuffleDeck();
    }

    public void ShuffleDeck(){
        Collections.shuffle(deck);
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
    /*
    public ArrayList getArrayList(){
        return deck;
    }
	*/
	
	
	
}

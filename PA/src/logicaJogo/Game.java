package logicaJogo;

import logicaJogo.events.Event;
import logicaJogo.cartas.EnemyCard;
import logicaJogo.cartas.EventCard;
import logicaJogo.cartas.StatusCard;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    
    private boolean over;
    
    private int actionPoints;
    private int day;
    private int iteration; //1-7
	
    private DiceRoll dice;

    private StatusCard status;
    private EnemyCard enemy;

    private ArrayList<EventCard> deck;

    public Game(){
        
        this.over = false;
        
        this.dice = new DiceRoll();
        
        this.status = new StatusCard();
        this.enemy = new EnemyCard();
	
        this.actionPoints = 0;
	
        this.day = 1;
<<<<<<< HEAD
        this.iteration = 0;
        
        CreateDeck();
        }
		
=======
	this.iteration = 0;
        
        /*
	for (int i = 0; i < 7 ; i++) {
            this.deck.add(new EventCard());
        }
	*/
		
    }
>>>>>>> 126b34bc04a5f4e097d47faf9169315981a2aaef

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
	
    public boolean getOver(){
        return over;
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
    
    public int getIt(){
        return this.iteration;
    }
    
    public StatusCard getStatus(){
        return status;
    }
    
    public EnemyCard getEnemy(){
        return enemy;
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

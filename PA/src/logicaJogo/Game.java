package logicaJogo;

import logicaJogo.events.*;
import logicaJogo.cartas.EnemyCard;
import logicaJogo.cartas.EventCard;
import logicaJogo.cartas.StatusCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Game {

    private boolean over;
    private boolean defaultTunnelMovement;
    private boolean raidSabotageOnly;
    private int rowChoice;

    private int actionPoints;
    private int day;
    private int iteration; //1-7

    private DiceRoll dice;

    private HashMap<DRM, Integer> drms;

    private StatusCard status;
    private EnemyCard enemy;

    private ArrayList<EventCard> deck;
    private ArrayList<String> info;

    public Game() {
        this.dice = new DiceRoll();
        this.status = new StatusCard();
        this.enemy = new EnemyCard();

        day = 1;
        iteration = actionPoints = iteration = 0;
        over = defaultTunnelMovement = raidSabotageOnly = false;

        drms = new HashMap();
        drms.put(DRM.SABOTAGE, 0);
        drms.put(DRM.MORALE, 0);
        drms.put(DRM.COUPURE, 0);
        drms.put(DRM.RAID, 0);
        drms.put(DRM.RAM, 0);
        drms.put(DRM.TOWER, 0);
        drms.put(DRM.TREBUCHET, 0);
        drms.put(DRM.CQB, 0);
        drms.put(DRM.CIRCLE, 0);

        deck = new ArrayList<>();
        info = new ArrayList<>();
        
    }


    //Deck Stuff

    public void CreateDeck() {
        deck.clear();
        deck.add(new EventCard(1, new TrebuchetEvent(), new TrebuchetEvent(), new TrebuchetEvent()));
        deck.add(new EventCard(2, new Illness(), new GuardsDistracted(), new TrebuchetEvent()));
        deck.add(new EventCard(3, new SuppliesSpoiled(), new BadWeather(), new BoilingOil()));
        deck.add(new EventCard(4, new DeathofaLeader(), new GateFortified(), new FlamingArrows()));
        deck.add(new EventCard(5, new VolleyofArrows(), new Collapsed(), new RepairedTrebuchet()));
        deck.add(new EventCard(6, new CoverofDarkness(), new EnemyFatigue(), new Rally()));
        deck.add(new EventCard(7, new DeterminedEnemy(), new IronShields(), new Faith()));
    }

    public void ShuffleDeck() {
        Collections.shuffle(deck);
    }

    public EventCard drawCard() {
        return deck.remove(0);
    }

    public void setRowChoice(int row) {
        rowChoice = row;
    }

    public int getRowChoice() {
        return rowChoice;
    }

    public boolean getGameResult() {
        return over;
    }

    public void setActionPoints(int ap) {
        this.actionPoints = ap;
    }
    
    public void reduceActionPoints(){
        this.actionPoints --;
    }

    public int getActionPoints() {
        return this.actionPoints;
    }
    
    public boolean useActionPoints() {
        if(getActionPoints() > 0){
            reduceActionPoints();
            return true;
        }
        else
            return false;
    }

    public int getDay() {
        return this.day;
    }

    public int getIteration() {
        return this.iteration;
    }

    public StatusCard getStatus() {
        return status;
    }

    public EnemyCard getEnemy() {
        return enemy;
    }

    public void addDay() {
        this.day++;
    }

    public int getRoll() {
        return dice.getRoll();
    }

    public void addInfo(String info) {
        this.info.add(info);
    }

    public ArrayList<String> getInfo() {
        return info;
    }

    public void clearInfo() {
        info.clear();
    }

    public void newTurn() {
        defaultTunnelMovement = true;
        clearDRM();
        actionPoints = 0;

        if (status.getTunnel() == 3)
            if (dice.getRoll() == 1)
                capture();
    }

    public void capture() {
        status.resetTunnel();
        status.resetExtraSupplies();
        status.decreaseMorale();
    }

    public void clearDRM(){
        drms.clear();
    }

    public HashMap<DRM, Integer> getDRM(){
        return drms;
    }

    public void setRaidSabotageOnly(){
        raidSabotageOnly = true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(status.toString());
        sb.append(enemy.toString());

        sb.append("Action Points: ").append(actionPoints).append("\n");

        return sb.toString();
    }

    //tunnel methods
    
    public void enterTunnel(){
        if(useActionPoints() && 
                getStatus().getTunnel() == 0)
            getStatus().increaseTunnel();
    }
    public void exitTunnel(){
        if(getStatus().getTunnel() != 0)
            getStatus().setTunnel(0);
    }
    public void paidTunnel(){
        if(useActionPoints())
            getStatus().setTunnel(3);
    }
    public void normalTunnel(){
        if(getStatus().getTunnel() > 0 && getStatus().getTunnel() < 3)
            getStatus().increaseTunnel();
    }
    
    
}

package logicaJogo.cartas;
import logicaJogo.events.Collapsed;
import logicaJogo.events.Event;
import logicaJogo.events.RepairedTrebuchet;
import logicaJogo.events.VolleyofArrows;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class EventCard extends Card {
    private int id;
    protected boolean turned = false;
    protected boolean used = false;
    private Event[] events;
    protected ImageIcon image;

    public EventCard(BufferedImage i, int id, Event e1, Event e2, Event e3){
        super();
        image =  new ImageIcon(i.getScaledInstance(215, 290, Image.SCALE_SMOOTH));
        this.events[0] = e1;
        this.events[1] = e2;
        this.events[2] = e3;
        this.id = id;
    }

    public ImageIcon getImage(){
        return image;
    }

    public boolean isTurned() {
        return turned;
    }

    public void turnCard(){
        turned = true;
    }

    public boolean isUsed() {
        return used;
    }

    public void useCard() {
        this.used = true;
    }

    public Event getEvent(int day) {
        return events[day - 1];
    }
    
    public int getID(){
        return id;
    }

    public int getAP(int day){
        int AP = 0;

        for(int i = 0; i < 3; i++){
            if(day - 1 == i)
            AP = events[i].ActionPointAvaible;
        }

        return AP;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n--> Event Card <--\n");
        sb.append("Card Number: ").append(id).append("\n");
        sb.append(events[0].toString()).append("\n");
        sb.append(events[1].toString()).append('\n');
        sb.append(events[2].toString()).append('\n');
        sb.append("--> Event Card <--");

        return sb.toString();
    }
}


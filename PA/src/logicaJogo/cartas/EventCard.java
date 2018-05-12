package logicaJogo.cartas;
<<<<<<< HEAD
import logicaJogo.Events.*;
=======
import logicaJogo.events.*;
>>>>>>> 126b34bc04a5f4e097d47faf9169315981a2aaef


public class EventCard extends Card {
    private int id;

    private Event[] events;

    public EventCard(int id, Event e1, Event e2, Event e3) {
        super();

        this.id = id;

        this.events = new Event[3];
        this.events[0] = e1;
        this.events[1] = e2;
        this.events[2] = e3;
    }

    public Event getEvent(int day) {
        return events[day - 1];
    }
    
    public int getID(){
        return id;
    }
}


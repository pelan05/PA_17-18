package logicaJogo.cartas;
import logicaJogo.events.*;


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
}


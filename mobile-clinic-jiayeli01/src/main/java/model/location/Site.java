package model.location;
import java.util.ArrayList;
import model.encounter.*;

public class Site {  
    String name;
    ArrayList<Event> events;
    Location location;

    public Site(String n, Location l){
        name = n;
        location = l;
        events = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event newEvent(String d){
        Event event = new Event(this, d);
        events.add(event);
        return event;
    }

    public int eventSize(){
        return events.size();
    }

    public Event getEventByIndex(int index){
        return events.get(index);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public void infectiousRate(){
        for (Event e : events){
            e.infectionRate();
        }
    }
}

package model.location;
import model.clinic.*;
import java.util.ArrayList;

public class LocationCatagory {
    Clinic clinic;
    ArrayList<Location> locations;

    public LocationCatagory(Clinic c){
        clinic = c;
        locations = new ArrayList<Location>();
    }

    public Location newLocation(String a){
        Location location = new Location(a);
        locations.add(location);   
        return location;   
    }

    public int countLocations(){
        return locations.size();
    }

    public Location getLocationByIndex(int index){
        return locations.get(index);
    }
    
}

package places;

import places.Place;

import java.util.ArrayList;
import java.util.List;

public class OpenPlace extends Place {
    public OpenPlace(String name) {
        super(name);
    }
    private ArrayList<ClosedPlace> closedPlaces = new ArrayList();
    public void addPlace(ClosedPlace closedPlace) {
        closedPlaces.add(closedPlace);
    }

}

package places;

import java.util.ArrayList;
import java.util.List;

public class OpenPlace extends Place {
    public OpenPlace(String name) {
        super(name);
    }
    private List<ClosedPlace> closedPlaces = new ArrayList();
    public void addPlace(ClosedPlace closedPlace) {
        closedPlaces.add(closedPlace);
    }

}

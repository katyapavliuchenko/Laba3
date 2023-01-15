package places;

import java.util.*;
import characters.*;
import enums.*;
import interfaces.*;
import things.SmallThing;



public class ClosedPlace extends Place {

    public ClosedPlace(String name) {
        super(name);
    }

    public ClosedPlace(String name, List<View> views, List<Smell> smells) {
        super(name, views, smells);
    }
    public ClosedPlace(String name, List<View> views) {
        super(name, views);
    }




}




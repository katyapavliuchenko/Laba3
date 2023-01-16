package places;

import java.util.*;
import characters.*;
import enums.*;
import interfaces.*;
import things.SmallThing;

public class ClosedPlace extends Place {
    double square;
    double height;
    public ClosedPlace(String name) {
        super(name);
    }
    public ClosedPlace(String name, double square, double height) {
        super(name);
        this.square = square;
        this.height = height;
    }
    public ClosedPlace(String name, View view, List<Smell> smells, double square, double height) {
        super(name, view, smells);
        this.square = square;
        this.height = height;
    }
    public ClosedPlace(String name, List<View> views, double square, double height) {
        super(name, views);
        this.square = square;
        this.height = height;
    }

}




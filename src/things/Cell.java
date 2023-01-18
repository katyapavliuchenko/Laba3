package things;

import characters.Animal;

import java.util.ArrayList;
import java.util.List;
public class Cell extends SmallThing {

    private Animal animal;
    public Cell(String name, Animal animal) {
        super(name);
        this.animal = animal;
    }
    @Override
    public String toString() {
        return getName() + " c " + animal;
    }
}

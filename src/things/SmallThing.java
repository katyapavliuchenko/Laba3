package things;

import enums.Smell;
import interfaces.*;

public class SmallThing implements IHoldable, ISeeable, IPuttableAbout, ISmellable {
    private String name;
    private Smell smell;
    public SmallThing(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

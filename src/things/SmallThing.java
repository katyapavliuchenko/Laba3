package things;

import enums.Smell;
import interfaces.*;

public class SmallThing implements IHoldable, IPuttableAbout {
    private final String name;
    private Smell smell;

    public SmallThing(String name) {
        this.name = name;
    }
    public SmallThing(String name, Smell smell) {
        this.name = name;
        this.smell = smell;
    }
    @Override
    public boolean checkHoldability() {
        return true;
    }

    @Override
    public boolean checkPutAboutAbility() {
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}

package things;

import things.SmallThing;

public class Lamp extends SmallThing {
    private boolean isOn;

    public Lamp(String name, boolean isOn) {
        super(name);
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}

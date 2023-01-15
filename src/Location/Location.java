package Location;

import characters.Character;
import places.Place;

public class Location {
    private Character character;
    private Place place;

    public Location(Character character) {
        this.character = character;
    }

    public void setLocation(Place place) {
        this.place = place;
        System.out.println(this.character + " в " + place);
    }

    public Place getLocation(Character character) {
        return this.place;
    }
}

package characters;

import java.util.*;

import interfaces.*;
import places.*;
import things.SmallThing;


public class Person extends Character {

    // Конструкторы
    public Person(String name) {
        super(name);
    }
    public Person(String name, int age) {
        super(name, age);
    }

    // Поля
    ArrayList<ClosedPlace> places = new ArrayList<>();

    // Геттеры и сеттеры
    public ArrayList<ClosedPlace> getPlaces() {
        return places;
    }

    // Методы
    public void ownPlace(ClosedPlace place) {
        places.add(place);
    }
    public void sitDown(Flat.Room.Furniture furniture) {
        System.out.println(this + " сидит на " + furniture);
        furniture.addCharacter(this);
    }
    public void sitUp(Flat.Room.Furniture furniture) {
        System.out.println(this + " встал с " + furniture);
        furniture.removeCharacter(this);
    }

    public void goOut(Place place) {
        System.out.println(this + " вышел из " + place);
        place.removeCharacter(this);
    }

    public void comeIn(Place place) {
        System.out.println(this + " вошел в " + place);
        place.getCharacters().add(this);
    }

    public void hold(IHoldable holdable) {
        if (holdable.checkHoldability()) {
            System.out.println(this + "взял " + holdable);
        } else{
            System.out.println(this + "не может поднять " + holdable + " !");
        }
    }

    public void putAbout(IHoldable holdable, IPuttableAbout puttable) {
        if (puttable.checkPutAboutAbility()) {
            System.out.println(this + " кладёт " + holdable + " около " + puttable);
        }
    }
    public void moveSomething(IHoldable holdable, Place placeFrom, Place placeTo) {
        if (holdable.checkHoldability()) {
            this.comeIn(placeFrom);
            this.hold(holdable);
            this.goOut(placeFrom);
            this.comeIn(placeTo);
            if (holdable instanceof Flat.Room.Furniture) {
                ((Flat.Room)placeFrom).removeFurniture(((Flat.Room.Furniture)holdable));
                ((Flat.Room)placeTo).addFurniture(((Flat.Room.Furniture)holdable));
            }
            else if (holdable instanceof SmallThing) {
                ((Flat.Room)placeFrom).removeSmallThing(((SmallThing)holdable));
                ((Flat.Room)placeTo).addSmallThing(((SmallThing)holdable));
            }
        }
        else {
            System.out.println(this + "не сможет поднять " + holdable);
        }

    }

    @Override
    public void say(String phrase) {
        if (phrase == "") {
            System.out.println(this + " молчит ");
        }
        else {
            System.out.println(this + " говорит:" + phrase);
        }
    }
    @Override
    public void say() {
        System.out.println(this + "говорит");
    }

    public void hit(Character character) {
        System.out.println(this + " ударил " + character);
    }


    public void stomp() {
        System.out.println(this + " затопал ногами ");
    }

    public void notHit(Character character) {
        System.out.println(this + " не ударил " + character);
    }

    public void notStomp() {
        System.out.println(this + " не затопал ногами ");
    }

    public void laugh() {
        System.out.println(this + " смеётся");
    }

}

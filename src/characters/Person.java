package characters;

import java.util.*;

import Exceptions.AddCharacterToFurnitureException;
import interfaces.*;
import places.*;
import things.SmallThing;


public class Person extends Character implements IHoldable {

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
    public void showPlaces() {
        System.out.println(getPlaces());
    }
    public void ownPlace(ClosedPlace place) {
        places.add(place);
    }
    public void sitDown(ISittable sittable) {
        System.out.println(this + " сидит на " + sittable);
        if (sittable instanceof Flat.Room.Furniture) {
            ((Flat.Room.Furniture)sittable).addCharacter(this);
        }
    }
    public void sitUp(ISittable sittable) {
        System.out.println(this + " встал с " + sittable);
        if (sittable instanceof Flat.Room.Furniture) {
            ((Flat.Room.Furniture)sittable).removeCharacter(this);;
        }
    }


    public void goOut(Place place) {
        System.out.println(this + " вышел из " + place);
        place.removeCharacter(this);
    }

    public void comeIn(Place place) {
        System.out.println(this + " вошел в " + place);
        place.getCharacters().add(this);
    }

    public void moveSomething(IHoldable holdable, Place placeFrom, Place placeTo) {
        this.comeIn(placeFrom);
        System.out.println(this + " взял " + holdable);
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


    public void putAbout(IHoldable holdable, IPuttableAbout puttable) {
        System.out.println(this + " кладёт " + holdable + " около " + puttable);
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

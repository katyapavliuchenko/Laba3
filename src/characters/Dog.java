package characters;

import java.util.*;

import Exceptions.AddCharacterToFurnitureException;
import Location.Location;
import interfaces.ILieable;
import interfaces.IPullable;
import interfaces.ISittable;
import interfaces.ISittableNear;
import org.w3c.dom.ls.LSOutput;
import places.*;
import things.SmallThing;

public class Dog extends Animal {

    // Конструкторы
    public Dog(String name) {
        super(name);
    }
    public Dog(String name, int age, boolean tail) {
        super(name, age, tail);
    }
    public Dog(String name, boolean tail) {
        super(name, tail);
    }

    // Поля
    public enum BodyPartsOfDogs implements IPullable {
        TAIL("хвост"), HIND_LEGS("задние лапы");
        String title;
        private BodyPartsOfDogs(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }
    private Set<BodyPartsOfDogs> bodyPartsOfDogs = EnumSet.of(BodyPartsOfDogs.TAIL, BodyPartsOfDogs.HIND_LEGS);


    // Геттеры и сеттеры

    public Set<BodyPartsOfDogs> getBodyPartsOfDogs() {
        return bodyPartsOfDogs;
    }

    // Методы
    public void lieDown(ILieable lieable)  {
        System.out.println(this + " легла на " + lieable);
        this.setHappiness(80);
        if (lieable instanceof Flat.Room.Furniture) {
            ((Flat.Room.Furniture)lieable).addCharacter(this);
        }
    }
    public void getUp(ILieable lieable) {
        System.out.println(this + " встала с " + lieable);
        if (lieable instanceof Flat.Room.Furniture) {
            ((Flat.Room.Furniture)lieable).removeCharacter(this);
        }
    }
    public void stretchLegs() {
        System.out.println(this + " протянула " + BodyPartsOfDogs.HIND_LEGS);
    }

    public void say() {
        System.out.println(this + " лает ");
        if (this.getPain() > 50) {
            System.out.println(this + " визжит ");
        }
    }
    public void sitNear(ISittableNear sittable) {
        System.out.println(this + " сидит перед " + sittable);
    }

    @Override
    public boolean checkPet() {
        return true;
    }
    public void think(Stranger stranger, Carpenter carpenter) {
        System.out.println(this + " думает, где лучше: у " + stranger + " или у " + carpenter);
        System.out.println();
        Dog pastDog = new Dog("Каштанка", 3, true);
        PetOwner[] people = new PetOwner[2];
        people[0] = stranger;
        people[1] = carpenter;
        for (int i = 0; i < people.length; i++) {
            List<ClosedPlace> places = people[i].getPlaces();
            for (ClosedPlace place : places) {
                place.showViews();
                if (place instanceof Flat) {
                    ((Flat) place).showAllFurniture();
                    ((Flat) place).showAllSmallThings();
                    if (((Flat) place).getAllSmallThings().size() < 3) {
                        System.out.println(place + " кажется пустой ");
                    } else if (((Flat) place).getAllSmallThings().size() > 5) {
                        System.out.println(place + " битком набита вещи ");
                    }
                }
                place.showSmells();
                pastDog.sitNear(people[i]);
                pastDog.lookAt(people[i]);
                if (people[i].getKindToAnimal()) {
                    people[i].notStomp();
                    people[i].notHit(pastDog);
                    people[i].say("");
                    pastDog.setHappiness(70);
                } else {
                    people[i].stomp();
                    people[i].hit(pastDog);
                    people[i].say(" Пошла вон, треклятая! ");
                    pastDog.setHappiness(10);
                }
            }
        }
        System.out.println();
        System.out.println(this + " перестаёт думать о " + stranger + " и " + carpenter);
        System.out.println();
    }


    public void remember (Carpenter carpenter, Boy boy){
            System.out.println(this + " вспоминает... ");
            System.out.println();
            Dog pastDog = new Dog("Каштанка", 3, true);
            Flat flatOfCarpenter = new Flat("Квартира столяра");
            Flat.Room lounge = flatOfCarpenter.new Room("Гостиная");
            Flat.Room.CraftingTable craftingTable = lounge.new CraftingTable("Верстак");
            flatOfCarpenter.addCharacter(pastDog);
            flatOfCarpenter.addCharacter(carpenter);
            System.out.println(this + " вспоминает " + carpenter + ", " + boy + " уютное местечко под " + craftingTable);
            carpenter.doSomethingInWinterEvenings();
            boy.pickUpPet(pastDog, Dog.BodyPartsOfDogs.HIND_LEGS, craftingTable);
            boy.play(pastDog, craftingTable);
            boy.makeHurt(pastDog);
            boy.orderToWalkOnHindLegs(pastDog);
            boy.pullPet(pastDog, Dog.BodyPartsOfDogs.TAIL);
            boy.orderToSniff(pastDog, new SmallThing("табак"));
            Focus focus = new Focus();
            focus.focus(boy, new SmallThing("кусочек мяса на ниточке"));
    }
}

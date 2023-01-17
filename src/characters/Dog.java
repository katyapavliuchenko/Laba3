package characters;

import java.util.*;

import interfaces.ILieable;
import places.ClosedPlace;
import places.Flat;
import things.SmallThing;

public class Dog extends Animal {
    public BodyPartsOfDogs tail = BodyPartsOfDogs.TAIL;
    public BodyPartsOfDogs hindLegs = BodyPartsOfDogs.HIND_LEGS;

    public Dog(String name) {
        super(name);
    }
    public Dog(String name, int age, boolean tail) {
        super(name, age, tail);
    }
    public Dog(String name, int age, String specie, boolean tail) {
        super(name, age, specie, tail);
    }

    // Поля
    public enum BodyPartsOfDogs {
        TAIL("хвост"), HIND_LEGS("задние лапы");
        final String title;
        private BodyPartsOfDogs(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }


    public void getUp(ILieable lieable) {
        System.out.println(this + " встала с " + lieable);
        if (lieable instanceof Flat.Room.Furniture) {
            ((Flat.Room.Furniture)lieable).removeCharacter(this);
        }
    }
    public void stretchLegs() {
        System.out.println(this + " протянула " + hindLegs);
    }
    public void walkOnHindLegs() {
        System.out.print(this + " ходит на " + hindLegs);
    }
    @Override
    public void say() {
        System.out.println(this + " лает ");
        if (this.getPain() > 50) {
            System.out.println(this + " визжит ");
        }
        if (this.getHappiness() < 10) {
            System.out.println(this + " скулит ");
        }
    }
    public void sitNear(Character character) {
        if (this.hashCode() == character.hashCode()) {
            System.out.println(this + " не может сидеть перед самим собой! ");

        }
        else {
            System.out.println(this + " сидит перед " + character);
        }

    }
    @Override
    public boolean checkPet() {
        return true;
    }
    public void wantToAnswer() {
        if (this.getHappiness() < 30) {
            System.out.print(this + " не хочет отвечать, потому что ");
        }
        else {
            System.out.println(this + " хочет ответить ");
        }
    }
    public void think(Stranger stranger, Carpenter carpenter) {
        System.out.println(this + " думает, где лучше: у " + stranger + " или у " + carpenter);
        System.out.println();
        Dog pastDog = new Dog("Каштанка", 3, true);
        PetOwner[] people = new PetOwner[2];
        people[0] = stranger;
        people[1] = carpenter;
        for (int i = 0; i < people.length; i++) {
            ArrayList<ClosedPlace> places = people[i].getPlaces();
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
            Carpenter pastCarpenter = new Carpenter("Лука Александрыч", 39, "Столяр", false);
            Flat flatOfCarpenter = new Flat("Квартира столяра", 35, 3);
            Flat.Room lounge = flatOfCarpenter.new Room("Гостиная");
            Flat.Room.CraftingTable craftingTable = lounge.new CraftingTable("Верстак");
            flatOfCarpenter.addCharacter(pastDog);
            flatOfCarpenter.addCharacter(pastCarpenter);
            System.out.println(this + " вспоминает " + carpenter + ", " + boy + ", " + " уютное местечко под " + craftingTable);
            pastCarpenter.doSomethingInWinterEvenings();
            boy.pickUpDog(pastDog, pastDog.hindLegs, craftingTable);
            boy.play(pastDog, craftingTable);
            boy.makeHurt(pastDog);
            boy.orderToWalkOnHindLegs(pastDog);
            boy.pullDog(pastDog, pastDog.hindLegs);
            boy.orderToSniff(pastDog);
            Boy.Focus focus = new Boy.Focus();
            focus.focus(boy, new SmallThing("кусочек мяса на ниточке"));
            System.out.print("Воспоминания ярче...");
            while (Math.random() < 0.4) {
                System.out.println(" всё ярче...");
            }
            this.setHappiness(5);
            this.say();
    }


}

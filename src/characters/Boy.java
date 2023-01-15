package characters;

import interfaces.*;
import places.Flat;

public class Boy extends Person {
    public Boy(String name) {
        super(name);
    }

    public Boy(String name, int age) {
        super(name);
    }

    public void play(Animal animal, Flat.Room.Furniture furniture) {
        System.out.println(this + " играет с " + animal + " у " + furniture);
    }


    public void makeHurt(Character character) {
        int painNow = character.getPain();
        painNow = (int) (painNow + (Math.random() * 91 + 10));
        character.setPain(painNow);
        System.out.println(this + " делает больно " + character);
        if (character.getPain() > 50) {
            System.out.println(character + " очень больно!");
        }
    }

    public void pickUpPet(Animal animal, IPullable bodyPart, IPuttableAbout puttableAbout) {
        System.out.println(this + " поднял " + animal + " из-под " + puttableAbout + " за " + bodyPart);

    }

    public void orderToWalkOnHindLegs(Animal animal) {
        animal.walkOnHindLegs();
        System.out.println("по приказу " + this);
    }

    public void orderToSniff(Animal animal, ISmellable smellable) {
        animal.sniff(smellable);
        System.out.println("по приказу " + this);
    }

    public void pullPet(Animal animal, IPullable bodyPart) {
        System.out.println(this + " дёргает " + animal + " за " + bodyPart);
        animal.say("Гав-гав");
    }


}

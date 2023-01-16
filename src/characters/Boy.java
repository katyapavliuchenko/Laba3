package characters;

import places.Flat;
import things.SmallThing;

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

    public void pickUpDog(Dog dog, Dog.BodyPartsOfDogs bodyPart, Flat.Room.Furniture furniture) {
        System.out.println(this + " поднял " + dog + " из-под " + furniture + " за " + bodyPart);

    }
    public void orderToWalkOnHindLegs(Dog dog) {
        dog.walkOnHindLegs();
        System.out.println("по приказу " + this);
    }

    public void orderToSniff(Dog dog, SmallThing smallThing) {
        dog.sniff(smallThing);
        System.out.println("по приказу " + this);
    }

    public void pullDog(Dog dog, Dog.BodyPartsOfDogs bodyPart) {
        System.out.println(this + " дёргает " + dog + " за " + bodyPart);
        dog.say();
    }


}

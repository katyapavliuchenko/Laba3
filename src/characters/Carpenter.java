package characters;

import things.SmallThing;

public class Carpenter extends PetOwner {
    public Carpenter(String name, boolean isKindToAnimal) {
        super(name, isKindToAnimal);
    }

    public Carpenter(String name, int age, boolean isKindToAnimal) {
        super(name, age, isKindToAnimal);
    }

    public void read(SmallThing thing) {
        System.out.println(this + " читает " + thing);
    }

    public void plane() {
        System.out.println(this + " строгает ");
    }

    public void doSomethingInWinterEvenings() {
        if (Math.random() < 0.6) {
            this.plane();
        }
        else {
            this.read(new SmallThing("книгу"));
        }
    }
}

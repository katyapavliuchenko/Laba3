package characters;

import interfaces.ILieable;
import interfaces.IPettable;
import places.Flat;

public class Animal extends Character implements IPettable {
    // Конструкторы
    public Animal(String name) {
        super(name);
    }

    public Animal(String name, int age) {
        super(name, age);
    }
    public Animal(String name, boolean tail) {
        super(name);
        isHaveTail = tail;
    }
    public Animal(String name, int age, boolean tail) {
        super(name, age);
        isHaveTail = tail;
    }

    private boolean isHaveTail;


    public void waveTail() {
        if (this.isHaveTail) {
            System.out.println(this + " виляет хвостом " );
        }
        // Для вывода текста
        System.out.println();
    }
    public void walkOnHindLegs() {
        System.out.print(this + " ходит на задних лапах ");
    }


    @Override
    public void say(String phrase) {
        System.out.println(this + " издаёт звуки " + phrase);
    }

    @Override
    public void say() {
        System.out.println(this + " издаёт звуки ");
    }

    @Override
    public boolean checkPet() {
        return false;
    }

    public void lieDown(ILieable lieable)  {
        if (lieable.checkLieabilityForAnimal()) {
            System.out.println(this + " лег на " + lieable);
            this.setHappiness(80);
            if (lieable instanceof Flat.Room.Furniture) {
                ((Flat.Room.Furniture)lieable).addCharacter(this);
            }
        } else {
            System.out.println(this + "не может лечь на " + lieable);
        }
    }
}

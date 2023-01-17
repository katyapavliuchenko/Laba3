package characters;


import interfaces.ILieable;
import interfaces.IPettable;
import places.Flat;

import java.util.Objects;

public class Animal extends Character implements IPettable {
    private boolean isHaveTail;
    private String specie;

    public Animal(String name) {
        super(name);
    }
    public Animal(String name, boolean tail) {
        super(name);
        isHaveTail = tail;
    }
    public Animal(String name, int age, boolean tail) {
        super(name, age);
        isHaveTail = tail;
    }
    public Animal(String name, int age, String specie, boolean tail) {
        super(name, age);
        isHaveTail = tail;
        specie = specie;
    }

    public void waveTail() {
        if (this.isHaveTail) {
            System.out.println(this + " виляет хвостом " );
        }
        // Для вывода текста
        System.out.println();
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
                ((Flat.Room.Furniture) lieable).addCharacter(this);
            }
        } else {
            System.out.println(this + "не может лечь на " + lieable);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return specie.equals(animal.specie) && getName().equals(animal.getName()) && getAge() == animal.getAge();
    }

    @Override
    public int hashCode() {
        int result = 31 * (specie != null ? specie.hashCode() : 0) + 17 * (getName() != null ? getName().hashCode() : 0) + 13 * (getAge() != 0 ? Integer.hashCode(getAge()) : 0) ;
        return result;
    }
}

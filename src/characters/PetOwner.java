package characters;

import java.util.ArrayList;
import java.util.List;

public class PetOwner extends Person {
    private ArrayList<Animal> pets = new ArrayList<>();

    private boolean isKindToAnimal;

    public ArrayList<Animal> getPets() {
        return pets;
    }


    public PetOwner(String name, boolean isKindToAnimal) {
        super(name);
        this.isKindToAnimal = isKindToAnimal;
    }
    public PetOwner(String name, int age, boolean isKindToAnimal) {
        super(name, age);
        this.isKindToAnimal = isKindToAnimal;
    }

    public boolean getKindToAnimal() {
        return isKindToAnimal;
    }


    public void ownPet(Animal animal) {
        if (animal.checkPet()) {
            pets.add(animal);
            System.out.println(this + " становится хозяином " + animal);
        }
        else {
            System.out.println(this + "не может стать хозяином " + animal);
        }
    }
    public void stopOwnPet(Animal animal) {
        pets.remove(animal);
        System.out.println(this + " больше не хозяин " + animal);
    }




}

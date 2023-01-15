package characters;

import things.Lamp;
import things.SmallThing;

public class Stranger extends PetOwner {

    // Конструкторы
    public Stranger(String name, boolean isKindToAnimal) {
        super(name, isKindToAnimal);
    }
    public Stranger(String name, int age, boolean isKindToAnimal) {
        super(name, age, isKindToAnimal);
    }

    // Поля

    // Геттеры и сеттеры

    // Методы
    public void smoke(SmallThing smokeable) {
        System.out.println(this + " курит " + smokeable + "...");
        while (Math.random() < 0.5) {
            System.out.println(this + " курит " + smokeable + "...");
        }
        System.out.println(this + " выкурил " + smokeable);
    }

    public void switchLamp (Lamp lamp) {
        if (lamp.isOn()) {
            lamp.setOn(false);
            System.out.println(this + " выключил " + lamp);
        }
        else {
            lamp.setOn(true);
            System.out.println(this + " включил " + lamp);
        }


    }
}

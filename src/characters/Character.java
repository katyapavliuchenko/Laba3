package characters;

import interfaces.*;
import things.SmallThing;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Character implements ISittable, ISittableNear, ISeeable, IHearable {

    // Конструкторы
    public Character(String name) {
        this.name = name;
    }
    public Character(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Поля
    private final String name;
    private int age;
    private int happiness;
    private int pain;
    private int food;
    private boolean isLying;
    ArrayList<SmallThing> smallThings = new ArrayList<>();



    // Геттеры и сеттеры
    public String getName() {
        return name;
    }
    public int getHappiness() {
        return happiness;
    }
    public void setHappiness(int happiness) {
        this.happiness = happiness;
        if (happiness >= 75) {
            System.out.println(this + " счастлива ");
        }
        else if (happiness >= 50 && happiness < 75) {
            System.out.println(this + " довольна ");
        }

        else if (happiness < 50 && happiness >= 25) {
            System.out.println(this + " спокойна ");
        }

        else if (happiness < 25) {
            System.out.println(this + " расстроена ");
        }
    }
    public int getPain() {
        return pain;
    }
    public void setPain(int pain) {
        this.pain = pain;
    }


    // Методы
    public void eat(int food) {
        this.food += food;
        System.out.println(this + " поела");
        if (food > 80) {
            System.out.println(this + " наелся");
        }
        else if (food <= 80 && food >= 70) {
            System.out.println(this + " опьянела от еды");
        }
        else if (food <= 30) {
            System.out.println(this + " не наелся");
        }
    }

    public abstract void say(String phrase);


    public void lookAt(ISeeable whatILookAt) {
        System.out.println(this + " смотрит на " + whatILookAt);

    }
    public void closeEyes() {
        System.out.println(this + " закрыла глаза ");
        // Для вывода кода
        System.out.println();
    }


    public void hear(String whatSay, IHearable whoSay, ISoundable whereSay) {
        System.out.println(this + " слышит " + whatSay + " от " + whoSay + " с " + whereSay);
    }

    public void wantToSay() {
        if (this.getHappiness() < 30) {
            System.out.print(this + " не хочет говорить, потому что ");
        }
        else {
            System.out.println(this + " хочет говорить ");
        }
    }

    public void sniff(ISmellable smellable) {
        System.out.print(this + " нюхает " + smellable + " ");
    }
    public void addSmallThing(SmallThing smallThing) {
        this.smallThings.add(smallThing);
    }
    public void removeSmallThing(SmallThing smallThing) {
        this.smallThings.remove(smallThing);
    }
    public void giveSomething(Character character, SmallThing smallThing) {
        character.addSmallThing(smallThing);
        System.out.println(this + " даёт " + character + " " + smallThing);
    }

    public void takeAwaySomething(Character character, SmallThing smallThing) {
        character.removeSmallThing(smallThing);
        System.out.println(this + " забирает у " + character + " " + smallThing);
    }



    // Переопределение методов класса Object
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return Objects.equals(name, character.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

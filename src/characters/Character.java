package characters;

import interfaces.Sayable;
import places.Place;
import things.SmallThing;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Character implements Sayable {
    private final String name;
    private int age;
    private int happiness;
    private int pain;
    private int food;
    ArrayList<SmallThing> smallThings = new ArrayList<>();
    public Character(String name) {
        this.name = name;
    }
    public Character(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHappiness() {
        return happiness;
    }
    public void setHappiness(int happiness) {
        this.happiness = happiness;
        if (happiness >= 75) {
            System.out.println(this + " счастлива ");
        }
        else if (happiness >= 50) {
            System.out.println(this + " довольна ");
        }

        else if (happiness >= 25) {
            System.out.println(this + " спокойна ");
        }

        else {
            System.out.println(this + " расстроена ");
        }
    }
    public int getPain() {
        return pain;
    }
    public void setPain(int pain) {
        this.pain = pain;
    }

    public void eat(int food) {
        this.food += food;
        System.out.println(this + " поела");
        if (food > 80) {
            System.out.println(this + " наелся");
        }
        else if (food >= 70) {
            System.out.println(this + " опьянела от еды");
        }
        else if (food <= 30) {
            System.out.println(this + " не наелся");
        }
    }

    @Override
    public void say(String phrase){
        System.out.println(this + "говорит " + phrase);
    };

    public void lookAt(Person person) {
        System.out.println(this + " смотрит на " + person);
    }

    public void closeEyes() {
        System.out.println(this + " закрыла глаза ");
        // Для вывода кода
        System.out.println();
    }

    public void hear(String whatSay, Sayable whoSay, Place place) {
        System.out.println(this + " слышит " + whatSay + " от " + whoSay + " с " + place);
    }
    public void sniffTobacco() {
        class Tobacco {
            private String tobacco;
            Tobacco(String tobacco) {
                this.tobacco = tobacco;
            }
            @Override
            public String toString() {
                return tobacco;
            }
        }
        Tobacco tobacco = new Tobacco("табак");
        System.out.print(this + " нюхает " + tobacco + " ");
    }
    public void addSmallThing(SmallThing smallThing) {
        this.smallThings.add(smallThing);
    }
    public void removeSmallThing(SmallThing smallThing) {
        this.smallThings.remove(smallThing);
    }
    public void giveSomething(Character character, SmallThing smallThing) {
        if (character.equals(this)) {
            System.out.println(character + " не может дать " + smallThing + " сам себе!");
        }
        else {
            character.addSmallThing(smallThing);
            System.out.println(this + " даёт " + character + " " + smallThing);
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return name.equals(character.name) && age == character.age;
    }

    @Override
    public int hashCode() {
        int result = 31 * (name != null ? name.hashCode() : 0) + 13 * (age != 0 ? Integer.hashCode(age) : 0) ;
        return result;
    }


}

package characters;

public class Animal extends Character {
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
}

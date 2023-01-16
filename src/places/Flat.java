package places;

import java.util.*;

import Exceptions.AddCharacterToFurnitureException;
import characters.Character;
import enums.*;
import interfaces.*;
import things.SmallThing;

public class Flat extends ClosedPlace {

    // Конструкторы
    public Flat(String name, double square, double height) {
        super(name, square, height);
    }

    public Flat(String name, View view, List<Smell> smells, double square, double height) {
        super(name, view, smells, square, height);
    }
    public Flat(String name, List<View> views, double square, double height) {
        super(name, views, square, height);
    }

    // Поля
    private List<Room> rooms = new ArrayList<> ();
    // Геттеры и сеттеры


    // Методы
    public void addRoom(Room room) {
        rooms.add(room);
    }
    public void showRooms() {
        String name = getName();
        System.out.println("В " + name + " есть " + rooms);
    }

    public void showCharacters() {
        System.out.print("В " + this + " находятся: ");
        List<Character> characters = getCharacters();
        for(int i = 0; i < characters.size(); i++) {
            System.out.print(characters.get(i));
            if (i + 1 < characters.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
        // Для вывода текста
        System.out.println();
    }

    public List<Room.Furniture> getAllFurniture() {
        List<Room.Furniture> allFurniture = new ArrayList<>();
        for (Room room : rooms) {
            List<Room.Furniture> furnitures = room.getFurnitures();
            if (!furnitures.isEmpty()) {
                allFurniture.addAll(furnitures);
            }
        }
        return allFurniture;
    }

    public void showAllFurniture() {
        List<Room.Furniture> allFurniture = getAllFurniture();
        System.out.print("В " + this + " есть мебель: ");
        for(int i = 0; i < allFurniture.size(); i++) {
            System.out.print(allFurniture.get(i));
            if (i + 1 < allFurniture.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public List<SmallThing> getAllSmallThings() {
        List<SmallThing> allSmallThings = new ArrayList<>();
        for (Room room : rooms) {
            List<SmallThing> smallThings = room.getSmallThings();
            if (!smallThings.isEmpty()) {
                allSmallThings.addAll(smallThings);
            }
        }
        return allSmallThings;

    }
    public void showAllSmallThings() {
        List<SmallThing> allSmallThings = getAllSmallThings();
        System.out.print("В " + this + " есть вещи: ");
        for(int i = 0; i < allSmallThings.size(); i++) {
            System.out.print(allSmallThings.get(i));
            if (i + 1 < allSmallThings.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }



    public class Room extends ClosedPlace {

        // Конструкторы
        public Room(String name) {
            super(name);
            Flat.this.addRoom(this);
        }

        // Поля
        private List<Furniture> furnitures = new ArrayList<>();
        private List<SmallThing> smallThings = new ArrayList<>();

        // Геттеры и сеттеры
        public List<Furniture> getFurnitures() {
            return furnitures;
        }

        public List<SmallThing> getSmallThings() {
            return smallThings;
        }

        // Методы
        public void addFurniture(Furniture furniture) {
            this.furnitures.add(furniture);
        }
        public void removeFurniture(Furniture furniture) {
            this.furnitures.remove(furniture);
        }

        public void addSmallThings(List<SmallThing> smallThings) {
            this.smallThings.addAll(smallThings);
        }

        public void addSmallThing(SmallThing smallThing) {
            this.smallThings.add(smallThing);
        }
        public void removeSmallThing(SmallThing smallThing) {
            this.smallThings.remove(smallThing);
        }
        @Override
        public void addCharacter(Character character) {
            this.getCharacters().add(character);
            Flat.this.addCharacter(character);
        }



        public class Furniture implements IHoldable, ILieable, IPuttableAbout {

            // Конструкторы
            public Furniture(String name) {
                this.name = name;
                Room.this.addFurniture(this);
            }
            public Furniture(String name, int mass) {
                this.name = name;
                this.mass = mass;
                Room.this.addFurniture(this);
            }

            // Поля
            private String name;
            private List<Character> characters = new ArrayList();
            private int mass;


            // Геттеры и сеттеры
            public String getName() {
                return name;
            }
            public List<Character> getCharacters() {
                return characters;
            }

            public int getMass() {
                return mass;
            }

            // Методы
            @Override
            public void addCharacter(Character character) {
                List<Character> allCharacters = this.getCharacters();
                for (Character allCharacter : allCharacters) {
                    try {
                        if (character.equals(allCharacter)) {
                            throw new AddCharacterToFurnitureException("Персонаж уже находится на этой мебели");
                        }
                    }
                    catch (AddCharacterToFurnitureException ex) {
                        System.out.println("Персонаж уже есть на данной мебели");
                    }
                }
                characters.add(character);
            }
            @Override
            public void removeCharacter(Character character) {
                characters.remove(character);
            }

            @Override
            public boolean checkHoldability() {
                return true;
            }

            @Override
            public boolean checkLieabilityForAnimal() {
                return true;
            }
            @Override
            public boolean checkLieabilityForPerson() {
                return true;
            }

            @Override
            public boolean checkPutAboutAbility() {
                return true;
            }

            @Override
            public String toString() {
                return name;
            }

        }

        public class Sofa extends Furniture {
            public Sofa(String name, int mass) {
                super(name, mass);
            }
            @Override
            public boolean checkHoldability() {
                return false;
            }
            @Override
            public boolean checkLieabilityForAnimal() {
                return true;
            }
            @Override
            public boolean checkLieabilityForPerson() {
                return true;
            }
        }

        public class Armchair extends Furniture {
            public Armchair(String name, int mass) {
                super(name, mass);
            }
            @Override
            public boolean checkHoldability() {
                return this.getMass() < 20;
            }
            @Override
            public boolean checkLieabilityForAnimal() {
                return true;
            }
            @Override
            public boolean checkLieabilityForPerson() {
                return true;
            }
        }

        public class Carpet extends Furniture {
            public Carpet(String name) {
                super(name);
            }

            @Override
            public boolean checkHoldability() {
                return true;
            }
            @Override
            public boolean checkLieabilityForAnimal() {
                return true;
            }
            @Override
            public boolean checkLieabilityForPerson() {
                return true;
            }
        }

        public class Mattress extends Furniture  {
            public Mattress(String name) {
                super(name);
            }
            @Override
            public boolean checkHoldability() {
                return true;
            }
            @Override
            public boolean checkLieabilityForAnimal() {
                return true;
            }
            @Override
            public boolean checkLieabilityForPerson() {
                return true;
            }
        }

        public class Table extends Furniture {
            public Table(String name) {
                super(name);
            }
            @Override
            public boolean checkHoldability() {
                return this.getMass() < 20;
            }
            @Override
            public boolean checkLieabilityForAnimal() {
                return true;
            }
            @Override
            public boolean checkLieabilityForPerson() {
                return false;
            }

        }
        public class CraftingTable extends Table {
            public CraftingTable(String name) {
                super(name);
            }
            @Override
            public boolean checkHoldability() {
                return this.getMass() < 20;
            }
            @Override
            public boolean checkLieabilityForAnimal() {
                return false;
            }
            @Override
            public boolean checkLieabilityForPerson() {
                return false;
            }
        }


    }


}

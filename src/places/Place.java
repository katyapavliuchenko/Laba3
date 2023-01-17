package places;

import java.util.*;

import Exceptions.CharacterAlreadyOnFurnitureException;
import characters.Character;
import enums.*;


public abstract class Place {
    private final String name;
    private ArrayList<Character> characters = new ArrayList<>();
    private ArrayList<View> views = new ArrayList<>();
    private ArrayList<Smell> smells = new ArrayList<>();
    public Place(String name) {
        this.name = name;
    }
    public Place(String name, List<View> views, List<Smell> smells) {
        this.name = name;
        this.views.addAll(views);
        this.smells.addAll(smells);
    }
    public Place(String name, View view, List<Smell> smells) {
        this.name = name;
        this.views.add(view);
        this.smells.addAll(smells);
    }
    public Place(String name, List<View> views) {
        this.name = name;
        this.views.addAll(views);
    }

    public String getName() {
        return name;
    }
    public List<Smell> getSmells() {
        return smells;
    }

    public List<View> getViews() {
        return views;
    }
    public List<Character> getCharacters() {
        return characters;
    }

    // Методы
    public void showSmells() {
        if (this.getSmells().isEmpty()) {
            System.out.print("В " + this.getName() + " не пахнет ничем ");
        }
        else {
            System.out.print("В " + this.getName() + " пахнет ");
            List<Smell> allSmells = getSmells();
            for(int i = 0; i < allSmells.size(); i++) {
                System.out.print(allSmells.get(i));
                if (i + 1 < allSmells.size()) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

    public void showViews() {
        if (this.getViews().isEmpty()) {
            System.out.println();
        }
        else {
            System.out.print("В " + this.getName() + " ");
            List<View> allViews = getViews();
            for(int i = 0; i < allViews.size(); i++) {
                System.out.print(allViews.get(i));
                if (i + 1 < allViews.size()) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }
    public void addCharacter(Character character) {
        characters.add(character);
    }
    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    @Override
    public String toString() {
        return name;
    }
}

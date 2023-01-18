package Exceptions;

import characters.Character;
import places.Flat;

public class CharacterAlreadyOnFurnitureException extends Exception {
    public CharacterAlreadyOnFurnitureException(Character character, Flat.Room.Furniture furniture) {
        System.err.println(character + " уже находится на " + furniture);
    }
}

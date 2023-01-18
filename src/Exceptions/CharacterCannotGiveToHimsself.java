package Exceptions;

import characters.Animal;
import characters.Person;
import things.SmallThing;

public class CharacterCannotGiveToHimsself extends RuntimeException {
    public CharacterCannotGiveToHimsself(Character character, SmallThing smallThing) {
        System.err.println(character + " не может дать " + smallThing + " сам себе! ");
    }
}

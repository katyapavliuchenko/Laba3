package interfaces;

import Exceptions.AddCharacterToFurnitureException;
import characters.Character;

public interface ILieable {
    void addCharacter(Character character) throws AddCharacterToFurnitureException;
    void removeCharacter(Character character);
    boolean checkLieabilityForAnimal();
    boolean checkLieabilityForPerson();
}

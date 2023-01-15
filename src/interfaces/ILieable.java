package interfaces;

import Exceptions.AddCharacterToFurnitureException;
import characters.Character;

public interface ILieable {

    // Методы
    void addCharacter(Character character) throws AddCharacterToFurnitureException;
    void removeCharacter(Character character);
}

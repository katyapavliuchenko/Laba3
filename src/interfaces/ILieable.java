package interfaces;
import characters.Character;

public interface ILieable {
    void addCharacter(Character character);
    void removeCharacter(Character character);
    boolean checkLieabilityForAnimal();
    boolean checkLieabilityForPerson();
}

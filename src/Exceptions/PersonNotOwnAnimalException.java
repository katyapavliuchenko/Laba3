package Exceptions;

import characters.Animal;
import characters.Person;

public class PersonNotOwnAnimalException extends Exception {
    public PersonNotOwnAnimalException(Person person, Animal animal) {
        System.err.println(person + " не является хозяином " + animal);
    }
}

import Exceptions.PersonNotOwnAnimalException;
import characters.*;
import enums.*;
import org.w3c.dom.ls.LSOutput;
import places.Flat;
import things.Cell;
import things.Lamp;
import places.OpenPlace;
import things.SmallThing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // квартира незнакомца
        Flat flatOfStranger = new Flat("Квартира незнакомца", Arrays.asList(View.POOR, View.UGLY), 35, 3);
        Flat.Room kitchenOfStranger = flatOfStranger.new Room("Кухня");
        Flat.Room loungeOfStranger = flatOfStranger.new Room("Гостиная");
        Flat.Room bedroomOfStranger = flatOfStranger.new Room("Спальня");
        Flat.Room.Carpet carpetOfStranger = loungeOfStranger.new Carpet("Ковёр");
        Flat.Room.Armchair armchairOfStranger = loungeOfStranger.new Armchair("Кресло", 30);
        Flat.Room.Sofa sofaOfStranger = loungeOfStranger.new Sofa("Диван", 100);
        Flat.Room.Table tableOfStranger = kitchenOfStranger.new Table("Стол");
        Flat.Room.Mattress mattressOfStranger = bedroomOfStranger.new Mattress("Матрас");
        Lamp lamp = new Lamp("Лампа", true);
        loungeOfStranger.addSmallThing(lamp);

        // квартира столяра
        Flat flatOfCarpenter = new Flat("Квартира столяра", View.FOG, Arrays.asList(Smell.GLUE, Smell.VARNISH, Smell.SHAVINGS), 40,  3.5);
        Flat.Room loungeOfCarpenter = flatOfCarpenter.new Room("Гостиная");
        Flat.Room bathroomOfCarpenter = flatOfCarpenter.new Room("Ванная комната");
        Flat.Room.Table tableOfCarpenter = loungeOfCarpenter.new Table("Стол");
        Flat.Room.CraftingTable craftingTable = loungeOfCarpenter.new CraftingTable("Верстак");
        SmallThing shavings = new SmallThing("Стружки", Smell.SHAVINGS);
        SmallThing jointers = new SmallThing("Рубанки");
        SmallThing chisels = new SmallThing("Стамески");
        SmallThing saws = new SmallThing("Пилы");
        SmallThing tub = new SmallThing("Лохань");
        Animal bird = new Animal("чижик") {
            @Override
            public void say() {
                System.out.println(this + " чирикает");
            }
        };
        Cell cell = new Cell("Клетка", bird);
        loungeOfCarpenter.addSmallThings(Arrays.asList(shavings, jointers, chisels, saws, cell));
        bathroomOfCarpenter.addSmallThing(tub);

        OpenPlace street = new OpenPlace("Улица");
        street.addPlace(flatOfCarpenter);
        street.addPlace(flatOfStranger);

        //создаю персонажей
        Dog dog = new Dog("Каштанка", 4, "Собака домашняя", true);
        Stranger stranger = new Stranger("Незнакомец", 30, "Клоун", true);
        stranger.ownPlace(flatOfStranger);
        Carpenter carpenter = new Carpenter("Лука Александрыч", 40, "Столяр", false);
        carpenter.ownPlace(flatOfCarpenter);
        carpenter.addPet(dog);
        Boy boy = new Boy("Федюшка", 10);

        //действия
        carpenter.stopOwnPet(dog);
        stranger.ownPet(dog);

        loungeOfStranger.addCharacter(dog);
        loungeOfStranger.addCharacter(stranger);
        flatOfStranger.showCharacters();

        dog.eat(75);
        dog.lieDown(carpetOfStranger);
        dog.stretchLegs();
        dog.waveTail();

        stranger.sitDown(armchairOfStranger);

        dog.think(stranger, carpenter);

        stranger.smoke(new SmallThing("сигару"));
        stranger.sitUp(armchairOfStranger);
        stranger.goOut(loungeOfStranger);
        stranger.moveSomething(mattressOfStranger, bedroomOfStranger, loungeOfStranger);
        stranger.say(" Эй ты, пёс, поди сюда!");
        stranger.putAbout(mattressOfStranger, sofaOfStranger);
        stranger.say(" Ложись здесь. Спи!");
        stranger.switchLamp(lamp);
        stranger.goOut(loungeOfStranger);
        System.out.println();

        dog.getUp(carpetOfStranger);
        dog.lieDown(mattressOfStranger);
        dog.closeEyes();

        Dog randomDog = new Dog("Собака");
        street.addCharacter(randomDog);
        randomDog.say();
        dog.hear("лай", randomDog, street);
        dog.setHappiness(20);
        dog.wantToAnswer();
        dog.remember(carpenter, boy);




























    }
}
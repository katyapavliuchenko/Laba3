import Exceptions.AddCharacterToFurnitureException;
import Location.*;
import characters.*;
import enums.*;
import places.*;
import things.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // квартира незнакомца
        Flat flatOfStranger = new Flat("Квартира незнакомца", Arrays.asList(View.POOR, View.UGLY));
        Flat.Room kitchenOfStranger = flatOfStranger.new Room("Кухня");
        Flat.Room loungeOfStranger = flatOfStranger.new Room("Гостиная");
        Flat.Room bedroomOfStranger = flatOfStranger.new Room("Спальня");
        Flat.Room.Carpet carpetOfStranger = loungeOfStranger.new Carpet("Ковёр");
        Flat.Room.Armchair armchairOfStranger = loungeOfStranger.new Armchair("Кресло");
        Flat.Room.Sofa sofaOfStranger = loungeOfStranger.new Sofa("Диван");
        Flat.Room.Table tableOfStranger = kitchenOfStranger.new Table("Стол");
        Flat.Room.Mattress mattressOfStranger = bedroomOfStranger.new Mattress("Матрас");
        Lamp lamp = new Lamp("Лампа", true);
        loungeOfStranger.addSmallThing(lamp);

        // квартира столяра
        Flat flatOfCarpenter = new Flat("Квартира столяра", Arrays.asList(View.FOG), Arrays.asList(Smell.GLUE, Smell.VARNISH, Smell.SHAVINGS));
        Flat.Room kitchenOfCarpenter = flatOfCarpenter.new Room("Кухня");
        Flat.Room loungeOfCarpenter = flatOfCarpenter.new Room("Гостиная");
        Flat.Room bathroomOfCarpenter = flatOfCarpenter.new Room("Ванная комната");
        Flat.Room.Table tableOfCarpenter = loungeOfCarpenter.new Table("Стол");
        Flat.Room.CraftingTable craftingTable = loungeOfCarpenter.new CraftingTable("Верстак");
        SmallThing shavings = new SmallThing("Стружки");
        SmallThing jointers = new SmallThing("Рубанки");
        SmallThing chisels = new SmallThing("Стамески");
        SmallThing saws = new SmallThing("Пилы");
        SmallThing tub = new SmallThing("Лохань");
        SmallThing cell = new SmallThing("Клетка с чижиком");
        loungeOfCarpenter.addSmallThings(Arrays.asList(shavings, jointers, chisels, saws, cell));
        bathroomOfCarpenter.addSmallThing(tub);

        //создаю персонажей
        Dog dog = new Dog("Каштанка", 4, true);
        Stranger stranger = new Stranger("Незнакомец", true);
        stranger.ownPlace(flatOfStranger);
        Carpenter carpenter = new Carpenter("Столяр Лука Александрыч", false);
        carpenter.ownPlace(flatOfCarpenter);
        Boy boy = new Boy("Федюшка");

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

        stranger.smoke(new SmallThing("сигару") {
            public void makeSmoke() {
            }
        });
        System.out.println(stranger.equals(stranger));
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

        OpenPlace street = new OpenPlace("Улица");
        Dog randomDog = new Dog("Собака");
        street.addCharacter(randomDog);
        randomDog.say("Гав-гав");
        dog.hear("Гав-Гав", randomDog, street);
        dog.setHappiness(20);
        dog.wantToSay();
        dog.remember(carpenter, boy);



















    }
}
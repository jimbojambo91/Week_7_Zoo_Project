package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.Animals.Lion;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class EnclosureTest {

    Enclosure enclosure;
    Enclosure smallEnclosure;
    Lion lion;
    MeatChunk meat;

    @Before
    public void before(){
        enclosure = new Enclosure ("Pride Rock", 100, Biome.SAVANNAH);
        smallEnclosure = new Enclosure("Tiny Town", 10, Biome.SAVANNAH);
        lion = new Lion("Leo", 'M', true, false);
        meat = new MeatChunk();
    }

    @Test
    public void getName(){
        String result = enclosure.getName();
        assertEquals("Pride Rock", result);
    }

    @Test
    public void getPlotSize(){
        int result = enclosure.getPlotSize();
        assertEquals(100, result);
    }

    @Test
    public void getBiome(){
        Biome result = enclosure.getBiome();
        assertEquals(Biome.SAVANNAH, result);
    }

    @Test
    public void getAnimalCount(){
        int result = enclosure.getAnimalCount();
        assertEquals(0, result);
    }

    @Test
    public void canAddAnimal(){
        enclosure.addAnimal(lion);
        assertEquals(1, enclosure.getAnimalCount());
    }

    @Test
    public void canRemoveAnimal(){
        enclosure.addAnimal(lion);
        enclosure.removeAnimal(lion);
        assertEquals(0, enclosure.getAnimalCount());
    }

    @Test
    public void canAddFoodToAvailableFood(){
        enclosure.addFood(meat);
        enclosure.addFood(meat);
        assertEquals(2, enclosure.getAvailableFoodCount());
    }

    @Test
    public void lionCanEatInEnclosure(){
        enclosure.addAnimal(lion);
        enclosure.addFood((meat));
    }

    @Test
    public void animalHasCurrentEnclosureTest(){
        enclosure.addAnimal(lion);
        Enclosure result = lion.getAnimalEnclosure();
        assertEquals(enclosure, result);
    }

    @Test
    public void poopAddstoFloor(){
        enclosure.addAnimal(lion);
        lion.eat(meat);
        lion.poop();
        int poopCount = enclosure.getEnclosureFloor().size();
        assertEquals(1, poopCount);
    }

    @Test
    public void multiplePoopAddsToFloor(){
        enclosure.addAnimal(lion);
        lion.eat(meat);
        lion.poop();
        lion.poop();
        int poopCount = enclosure.getEnclosureFloor().size();
        assertEquals(2, poopCount);
    }

    @Test
    public void eatingFiveTimesMakesPoop(){
        enclosure.addAnimal(lion);
        lion.eat(meat);
        lion.eat(meat);
        lion.eat(meat);
        lion.eat(meat);
        lion.eat(meat);
        int result = lion.bellyCount();
        assertEquals(0, result);
    }

//    @Test
//    public void tooMuchPoopMakesAnimalsSad(){
//        enclosure.addAnimal(lion);
//        lion.poop();
//        lion.poop();
//        lion.poop();
//        lion.poop();
//        lion.poop();
//        lion.poop();
//        int poopCount = enclosure.getEnclosureFloor().size();
//        assertEquals(6, poopCount);
//        int result = lion.getHappiness();
//        assertEquals(10, result);
//    }

    @Test
    public void animalsTakeUpSpace(){
        enclosure.addAnimal(lion);
        int lionSpace = lion.getPreferredSpace();
        assertEquals(25, lionSpace);
    }

    @Test
    public void smallEnclosureMakesAnimalsSad(){
        smallEnclosure.addAnimal(lion);
        int result = lion.getHappiness();
        assertEquals(40, result);
    }
}

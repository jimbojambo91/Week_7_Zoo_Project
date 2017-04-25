package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.Animals.Gazelle;
import example.codeclan.com.zooproject.Animals.Lion;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 21/04/2017.
 */

public class LionTest {

    Lion lion;
    Gazelle gazelle;
    MeatChunk meat;
    Enclosure enclosure;

    @Before
    public void before(){
        lion = new Lion("Leo", 'M', true, false);
        gazelle = new Gazelle("Garry", FoodType.MEAT, 'M', true, false);
        meat = new MeatChunk();
        enclosure = new Enclosure("Pride Rock", 100, Biome.SAVANNAH);
    }

    @Test
    public void lionCanEatGazelle(){
        lion.eat(gazelle);
        assertEquals(1, lion.bellyCount());
    }

    @Test
    public void getLionHungerTest(){
        int result = lion.getHunger();
        assertEquals(100, result);
    }

    @Test
    public void eatingAddsToHungerBar(){
        lion.eat(gazelle);
        int result = lion.getHunger();
        assertEquals(100, result);
    }

//    @Test
//    public void lionSleepTest(){
//        String result = lion.sleep();
//        assertEquals("Leo the Lion went to sleep", result);
//    }

    @Test
    public void sleepingLowersHungerBar(){
        lion.sleep();
        int result = lion.getHunger();
        assertEquals(50, result);
    }

    @Test
    public void lionSleepAndEatTest(){
        lion.sleep();
        lion.eat(gazelle);
        int result = lion.getHunger();
        assertEquals(80, result);
    }

    @Test
    public void lionHasLog(){
        lion.sleep();
        lion.eat(gazelle);
        lion.eat(meat);
        lion.printAnimalLog();
        assertNotNull(lion.getAnimalLog());
    }

    @Test
    public void lionWillEatWhenHungry(){
        enclosure.addAnimal(lion);
        lion.poop();
    }


}

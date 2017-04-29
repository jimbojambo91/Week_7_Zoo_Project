package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.Animals.AnimalFactory;
import example.codeclan.com.zooproject.Animals.Gazelle;
import example.codeclan.com.zooproject.Animals.Lion;
import example.codeclan.com.zooproject.Food.FoodType;
import example.codeclan.com.zooproject.Food.MeatChunk;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.ZooManagement.ZooAnimals;

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
    Enclosure enclosure2;

    @Before
    public void before(){
        lion = (Lion) AnimalFactory.CreateAnimal(ZooAnimals.LION, "Leo", 'M', true, 500 );
        gazelle = (Gazelle) AnimalFactory.CreateAnimal(ZooAnimals.GAZELLE, "Garry", 'M', true, 500 );
        meat = new MeatChunk();
        enclosure = new Enclosure("Pride Rock", 100, Biome.SAVANNAH);
        enclosure2 = new Enclosure("Arctic Tundra", 100, Biome.ARCTIC);
    }

    @Test
    public void lionCanEatGazelle(){
        lion.eat(meat);
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

    @Test
    public void lionHasStrength(){
        int result = lion.getStrength();
        assertEquals(50, result);
    }

    @Test
    public void lionEatsGazelleWhenVeryHungry(){
        enclosure.addAnimal(gazelle);
        enclosure.addAnimal(lion);
        lion.addToHunger(-90);
        int result = lion.bellyCount();
        assertEquals(1,result);
        int count = enclosure.getAnimalCount();
        assertEquals(1,result);
    }

    @Test
    public void lionGetsUnhappyInWrongBiome(){
        enclosure2.addAnimal(lion);
        int result = lion.getHappiness();
        assertEquals(25, result);
    }


}

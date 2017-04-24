package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 21/04/2017.
 */

public class LionTest {

    Lion lion;
    Gazelle gazelle;
    MeatChunk meat;

    @Before
    public void before(){
        lion = new Lion("Leo", FoodType.MEAT, 'M', true, false);
        gazelle = new Gazelle("Garry", FoodType.MEAT, 'M', true, false);
        meat = new MeatChunk();
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


}

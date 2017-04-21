package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 21/04/2017.
 */

public class GazelleTest {
    Gazelle gazelle;
    Lion lion;
    Grass grass;

    @Before
    public void before(){
        lion = new Lion("Leo", FoodType.MEAT, 'M', true, Biome.SAVANNAH, false);
        gazelle = new Gazelle("Garry", FoodType.MEAT, 'M', true, Biome.SAVANNAH, false);
        grass = new Grass();
    }

    @Test
    public void getName(){
        String result = gazelle.getName();
        assertEquals("Garry",  result);
    }

    @Test
    public void hasBelly(){
        int result = gazelle.getBelly().size();
        assertEquals(0, result);
    }

    @Test
    public void bellyCount(){
        int result = gazelle.bellyCount();
        assertEquals(0,result);
    }

    @Test
    public void gazelleCanEatGrass(){
        gazelle.eat(grass);
        assertEquals(1, gazelle.bellyCount());
    }

    @Test
    public void gazelleCannotEatLion(){
        gazelle.eat(lion);
        assertEquals(0, gazelle.bellyCount());

    }
}

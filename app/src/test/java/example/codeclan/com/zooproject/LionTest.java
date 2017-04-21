package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 21/04/2017.
 */

public class LionTest {

    Lion lion;
    Gazelle gazelle;

    @Before
    public void before(){
        lion = new Lion("Leo", FoodType.MEAT, 'M', true, Biome.SAVANNAH, false);
        gazelle = new Gazelle("Garry", FoodType.MEAT, 'M', true, Biome.SAVANNAH, false);
    }

    @Test
    public void lionCanEatGazelle(){
        lion.eat(gazelle);
        assertEquals(1, lion.bellyCount());
    }

}

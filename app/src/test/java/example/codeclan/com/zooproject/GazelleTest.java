package example.codeclan.com.zooproject;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 21/04/2017.
 */

public class GazelleTest {
    Gazelle gazelle;
    Lion lion;
    Grass grass;

    @Before
    public void before(){
        lion = new Lion("Leo", 'M', true, false);
        gazelle = new Gazelle("Garry", FoodType.MEAT, 'M', true, false);
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
    public void canJsonify() {
        Gson gson = new Gson();
        String gazzelleString = gson.toJson(gazelle);
        assertNotNull(gazzelleString);
        Gazelle fromJson = gson.fromJson(gazzelleString, Gazelle.class);
        assertNotNull(fromJson);
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

    @Test
    public void gazelleSleepAndEatTest(){
        gazelle.sleep();
        gazelle.eat(grass);
        int result = gazelle.getHunger();
        assertEquals(65, result);
    }
}

package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class AnimalTest {
    Animal animal;

    @Before
    public void before(){
        animal = new Animal("Leo", "Lion", 'M', true, Biome.SAVANNAH, false);
    }

    @Test
    public void getName(){
        String result = animal.getName();
        assertEquals("Leo", result);
    }

    @Test
    public void getType(){
        String result = animal.getType();
        assertEquals("Lion", result);
    }

    @Test
    public void getGender(){
        char result = animal.getGender();
        assertEquals('M', result);
    }

    @Test
    public void getMaturity(){
        boolean result = animal.getMaturity();
        assertEquals(true, result);
    }

    @Test
    public void getPreferredBiome(){
        Biome result = animal.getPreferredBiome();
        assertEquals(Biome.SAVANNAH, result);
    }

    @Test
    public void IsSolitary(){
        boolean result = animal.getSolitary();
        assertEquals(false, result);
    }

    @Test
    public void getHunger(){
        int result = animal.getHunger();
        assertEquals(100, result);
    }

    @Test
    public void getHappiness(){
        int result = animal.getHappiness();
        assertEquals(50, result);
    }
}

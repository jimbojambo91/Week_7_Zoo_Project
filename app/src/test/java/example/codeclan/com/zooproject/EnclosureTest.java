package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class EnclosureTest {

    Enclosure enclosure;
    Animal animal;

    @Before
    public void before(){
        enclosure = new Enclosure ("Pride Rock", 100, Biome.SAVANNAH);
        animal = new Animal("Leo", "Lion", 'M', true, Biome.SAVANNAH, false);
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
        enclosure.addAnimal(animal);
        assertEquals(1, enclosure.getAnimalCount());
    }

    @Test
    public void canRemoveAnimal(){
        enclosure.addAnimal(animal);
        enclosure.removeAnimal(animal);
        assertEquals(0, enclosure.getAnimalCount());
    }
}

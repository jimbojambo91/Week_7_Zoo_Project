package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 21/04/2017.
 */

public class TestGazelle {
    Gazelle gazelle;
    Animal animal;

    @Before
    public void before(){
        animal = new Animal("Leo", "Lion", 'M', true, Biome.SAVANNAH, false);
        gazelle = new Gazelle("Garry", "Gazelle", 'M', true, Biome.SAVANNAH, false);
    }

    @Test
    public void gazelleCanBeEaten(){

    }
}

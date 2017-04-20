package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class EnclosureTest {

    Enclosure enclosure;

    @Before
    public void before(){
        Enclosure enclosure = new Enclosure ("Pride Rock", 100, Biome.SAVANNAH);
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
}

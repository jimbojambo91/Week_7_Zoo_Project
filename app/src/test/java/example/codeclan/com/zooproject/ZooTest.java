package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.ZooManagement.Zoo;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class ZooTest {

    Zoo zoo;
    Enclosure enclosure;

    @Before
    public void before() {
        zoo = new Zoo("Edinburgh Zoo", 100.00);
        enclosure = new Enclosure("Pride Rock", 100, Biome.SAVANNAH);
    }

    @Test
    public void getName() {
        String result = zoo.getName();
        assertEquals("Edinburgh Zoo", result);
    }

    @Test
    public void getZooFunds() {
        double result = zoo.getZooFunds();
        assertEquals(100.00, result);
    }

    @Test
    public void getEnclosureCount() {
        int result = zoo.getEnclosureCount();
        assertEquals(0, result);
    }

    @Test
    public void canAddEnclosure() {
        zoo.addEnclosure(enclosure);
        assertEquals(1, zoo.getEnclosureCount());
    }

    @Test
    public void canRemoveEnclosure() {
        zoo.addEnclosure(enclosure);
        zoo.removeEnclosure(enclosure);
        assertEquals(0, zoo.getEnclosureCount());
    }

    @Test
    public void findEnclosureByName(){
        zoo.addEnclosure(enclosure);
        String enclosureName = "Pride Rock";
        Enclosure result = zoo.findEnclosureByName(enclosureName);
        assertEquals(enclosure, result);
    }

}

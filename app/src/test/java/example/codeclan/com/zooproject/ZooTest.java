package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class ZooTest {

    Zoo zoo;

    @Before
    public void before(){
        zoo = new Zoo("Edinburgh Zoo", 100.00);
    }

    @Test
    public void getName(){
        String result = zoo.getName();
        assertEquals("Edinburgh Zoo", result);
    }

    @Test
    public void getZooFunds(){
        double result = zoo.getZooFunds();
        assertEquals(100.00, result);

    }


}

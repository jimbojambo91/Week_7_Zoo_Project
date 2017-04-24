package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class VisitorTest {
    Visitor visitor;

    @Before
    public void before(){
        visitor = new Visitor();
    }

//    @Test
//    public void getName(){
//        String result = visitor.getName();
//        assertEquals("James Duncan", result);
//    }
//
//    @Test
//    public void getFunds(){
//        double result = visitor.getCustomerFunds();
//        assertEquals(500.00, result);
//    }
//
//    @Test
//    public void getFavouriteAnimal(){
//        String result = visitor.getFavouriteAnimal();
//        assertEquals("Lion", result);
//    }

    @Test
    public void getNutritionalValue(){
        int result = visitor.getNutritionalValue();
        assertEquals(50, result);
    }

//    @Test
//    public void getGender(){
//        char result = visitor.getGender();
//            assertEquals('M', result);
//    }


}

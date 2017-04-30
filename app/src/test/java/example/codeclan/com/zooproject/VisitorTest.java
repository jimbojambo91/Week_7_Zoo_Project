package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.People.PersonFactory;
import example.codeclan.com.zooproject.People.Visitor;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class VisitorTest {
    Visitor visitor;
    Enclosure enclosure;

    @Before
    public void before(){
        visitor = PersonFactory.getRandomVisitor();
        enclosure = new Enclosure("Lion House", 100, Biome.SAVANNAH);
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

    @Test
    public void visitorCanVisit(){
        visitor.visit(enclosure);
    }

    @Test
    public void visitorGetThirst(){
        int result = visitor.getThirst();
        assertEquals(75, result);
    }

    @Test
    public void canAddToThrist(){
        visitor.addToThirst(-10);
        int result = visitor.getThirst();
        assertEquals(65, result);
    }

    @Test
    public void visitorGetHunger(){
        int result = visitor.getHunger();
        assertEquals(75, result);
    }

    @Test
    public void canAddToHunger(){
        visitor.addToHunger(-10);
        int result = visitor.getHunger();
        assertEquals(65, result);
    }

    @Test
    public void canEatEdibleItem(){

    }


}

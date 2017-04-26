package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.People.PersonFactory;
import example.codeclan.com.zooproject.People.Visitor;
import example.codeclan.com.zooproject.ZooManagement.BurgerShop;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 26/04/2017.
 */

public class BurgerShopTest {

    BurgerShop burgerShop;
    Visitor visitor;

    @Before
    public void before(){
        burgerShop = new BurgerShop("Bob's Burgers");
        visitor = PersonFactory.getRandomVisitor();
    }

    @Test
    public void burgerShopCanSellBurger(){
        burgerShop.addToQueue(visitor);
        burgerShop.sell(visitor);
        int result = visitor.getItems().size();
        assertEquals(1, result);
        double funds = burgerShop.getShopFunds();
        assertEquals(505.00, funds);
    }
}

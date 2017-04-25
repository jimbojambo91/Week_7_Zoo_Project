package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.People.PersonFactory;
import example.codeclan.com.zooproject.People.Visitor;
import example.codeclan.com.zooproject.People.ZooKeeper;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.ZooManagement.Zoo;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class ZooTest {

    Zoo zoo;
    Enclosure enclosure;
    Visitor visitor;

    @Before
    public void before() {
        zoo = new Zoo("Edinburgh Zoo", 10000.00);
        enclosure = new Enclosure("Pride Rock", 100, Biome.SAVANNAH);
        visitor = PersonFactory.getRandomVisitor();
    }

    @Test
    public void getName() {
        String result = zoo.getName();
        assertEquals("Edinburgh Zoo", result);
    }

    @Test
    public void getZooFunds() {
        double result = zoo.getZooFunds();
        assertEquals(10000.00, result);
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

    @Test
    public void zooCanHireZooKeeper(){
        zoo.hireZooKeeper();
        int result = zoo.totalStaffCount();
        assertEquals(1, result);
    }

    @Test
    public void zooCanHireEntertainer(){
        zoo.hireEntertainer();
        int result = zoo.totalStaffCount();
        assertEquals(1, result);
    }

//    @Test
//    public void zooCanFireZooKeeper(){
//        zoo.hireZooKeeper();
//        int result = zoo.totalStaffCount();
//        assertEquals(1, result);
//    }

    @Test
    public void canPayStaffTest(){
        zoo.hireZooKeeper();
        zoo.payStaff();
        double result = zoo.getZooFunds();
        assertEquals(9700.00, result);
    }

    @Test
    public void canSellTicket(){
        zoo.sellTicket(visitor);
        double result = zoo.getZooFunds();
        assertEquals(10015.00, result);
        int count = zoo.getVisitorCount();
        assertEquals(1, count);

    }

}

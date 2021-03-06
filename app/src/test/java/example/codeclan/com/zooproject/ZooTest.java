package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.Animals.AnimalFactory;
import example.codeclan.com.zooproject.Animals.Gazelle;
import example.codeclan.com.zooproject.Animals.Lion;
import example.codeclan.com.zooproject.Food.Burger;
import example.codeclan.com.zooproject.People.PersonFactory;
import example.codeclan.com.zooproject.People.Visitor;
import example.codeclan.com.zooproject.People.ZooKeeper;
import example.codeclan.com.zooproject.ZooManagement.BurgerShop;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.ZooManagement.Shop;
import example.codeclan.com.zooproject.ZooManagement.Zoo;
import example.codeclan.com.zooproject.ZooManagement.ZooAnimals;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class ZooTest {

    Zoo zoo;
    Enclosure enclosure;
    Visitor visitor;
    Lion lion;
    BurgerShop burgerShop;

    @Before
    public void before() {
        zoo = new Zoo("Edinburgh Zoo", 10000.00);
        enclosure = new Enclosure("Pride Rock", 100, Biome.SAVANNAH);
        visitor = PersonFactory.getRandomVisitor();
        lion = (Lion) AnimalFactory.CreateAnimal(ZooAnimals.LION, "Leo", 'M', true, 500 );
        burgerShop = new BurgerShop("Bob's Burgers");
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
    public void findShopByNameTest(){
        zoo.addShop(burgerShop);
        Shop result = zoo.findShopByName("Bob's Burgers");
        assertEquals(burgerShop, result);
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

    @Test
    public void visitorCanVisitEnclosure(){
        enclosure.addAnimal(lion);
        visitor.visit(enclosure);
    }

    @Test
    public void zooCanBuildBurgerShop(){
        zoo.buildBurgerShop("Bob's Burgers");
        int result = zoo.getShopCount();
        assertEquals(1, result);
        double amount = zoo.getZooFunds();
        assertEquals(9500.00, amount);
    }

    @Test
    public void zooCanBuildMultipleShops(){
        zoo.buildBurgerShop("Bob's Burgers");
        zoo.buildBurgerShop("Bob's Burgers 2");
        int result = zoo.getShopCount();
        assertEquals(2, result);
    }

    @Test
    public void visitorWillLeaveZooIfNoMoney(){
        zoo.sellTicket(visitor);
        visitor.setWallet(5.00);
        zoo.updateVisitors();
        int count = zoo.getExitPathCount();
        assertEquals(1, count);
    }

    @Test
    public void visitorWillGoBuyFoodIfHungry(){
        zoo.buildBurgerShop("Bob's Burgers");
        zoo.hireShopWorker();
        zoo.placeShopWorkerInShop(zoo.findShopByName("Bob's Burgers"));
        zoo.sellTicket(visitor);
        visitor.addToHunger(-60);
        zoo.update();
        zoo.update();
    }

    @Test
    public void visitorWillGoBuyDrinkIfThirsty(){
        zoo.buildSodaShack("Burpees");
        zoo.hireShopWorker();
        zoo.placeShopWorkerInShop(zoo.findShopByName("Burpees"));
        zoo.sellTicket(visitor);
        visitor.addToThirst(-60);
        zoo.update();
        zoo.update();
    }

    @Test
    public void visitorWillVisitEnclosureIfContent(){
        zoo.addEnclosure(enclosure);
        zoo.buildSodaShack("Burpees");
        zoo.sellTicket(visitor);
        zoo.updateVisitors();
    }

    @Test
    public void visitorLogicTest(){
        zoo.buildNewEnclosure("Pride Rock", 100, Biome.SAVANNAH);
        zoo.update();
        zoo.update();
        zoo.update();
        zoo.update();
        zoo.update();
    }

    @Test
    public void zooCanBuildEnclosure(){
        zoo.buildNewEnclosure("Pride Rock", 100, Biome.SAVANNAH);
        int result = zoo.getEnclosureCount();
        assertEquals(1, result);
    }

    @Test
    public void zooCanBuyLion(){
        zoo.buyMale(ZooAnimals.LION);
        int count = zoo.getTemporaryStorage().size();
        assertEquals(1,count);
    }

    @Test
    public void getEnclosureByNameTest(){
        zoo.buildNewEnclosure("check", 100, Biome.SAVANNAH);
        Enclosure testEnclosure = zoo.getEnclosureByName("check");
        String name = testEnclosure.getName();
        assertEquals("check", name);

    }

    @Test
    public void canGetStaffSalary(){
        ZooKeeper zookeeper = PersonFactory.getRandomZooKeeper();
        zoo.addToSalaries(zookeeper, 100.00);
        double value = zoo.getStaffSalary(zookeeper);
        assertEquals(100.00, value);
    }




    @Test
    public void canAddToNamedEnclosure(){
        zoo.buildNewEnclosure("Pride Rock", 100, Biome.SAVANNAH);
        zoo.buyMale(ZooAnimals.LION);

    }

    @Test
    public void zooSetUp(){
        zoo.buildNewEnclosure("Pride Rock", 100, Biome.SAVANNAH);
        zoo.buildNewEnclosure("Arctic Tundra", 100, Biome.ARCTIC);
        zoo.buildNewEnclosure("The Den", 100, Biome.WOODLAND);
        zoo.buildNewEnclosure("African Plains", 100, Biome.SAVANNAH);
        zoo.buildBurgerShop("Bob's Burgers");
        zoo.buildSodaShack("Burpees");
        zoo.buyMale(ZooAnimals.LION);
        zoo.buyMale(ZooAnimals.GAZELLE);
        zoo.buyFemale(ZooAnimals.GAZELLE);
    }

    @Test
    public void zooCanPlaceWorkerInShop(){
        zoo.hireShopWorker();
        zoo.placeShopWorkerInShop(burgerShop);
        assertEquals(1, burgerShop.getStaffLength());
    }

    @Test
    public void visitorComesWithUmbrella(){
        zoo.buildBurgerShop("check");
        zoo.hireShopWorker();
        Shop shop = zoo.findShopByName("check");
        zoo.placeShopWorkerInShop(shop);
        Burger burger = new Burger();
        visitor.addToItems(burger);
        visitor.addToHunger(-60);
        zoo.addVisitor(visitor);
        zoo.update();

    }


}

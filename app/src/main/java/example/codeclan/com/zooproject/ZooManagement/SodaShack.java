package example.codeclan.com.zooproject.ZooManagement;


import example.codeclan.com.zooproject.Food.DrinkableFactory;
import example.codeclan.com.zooproject.Food.Soda;
import example.codeclan.com.zooproject.Food.ZooFood;
import example.codeclan.com.zooproject.People.Visitor;

/**
 * Created by user on 26/04/2017.
 */

public class SodaShack extends Shop implements Thirstable{

    public SodaShack(String name){
        super(name, 500, 2.50, ShopType.DRINK);
    }

    public void sell(Visitor visitor){
        Soda soda = (Soda) DrinkableFactory.createDrinkable(ZooFood.SODA);
        addToLog("Sold Soda to " + visitor.getName());
        visitor.addToItems(soda);
        visitor.amendWallet(-getStockPrice());
        addShopFunds(getStockPrice());
        serveFirstPersonInQueue();
    }
}

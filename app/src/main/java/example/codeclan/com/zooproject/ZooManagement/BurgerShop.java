package example.codeclan.com.zooproject.ZooManagement;

import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Food.Burger;
import example.codeclan.com.zooproject.Food.EdibleFactory;
import example.codeclan.com.zooproject.Food.ZooFood;
import example.codeclan.com.zooproject.People.Visitor;

/**
 * Created by user on 26/04/2017.
 */

public class BurgerShop extends Shop implements Eatable {

    public BurgerShop(String name){
        super(name, 500, 5.00, ShopType.EAT);
    }

    public void sell(Visitor visitor){
        Burger burger = (Burger) EdibleFactory.createEdible(ZooFood.BURGER);
        addToLog("Sold Burger to " + visitor.getName());
        visitor.addToItems(burger);
        visitor.amendWallet(-getStockPrice());
        addShopFunds(getStockPrice());
        serveFirstPersonInQueue();
    }

}

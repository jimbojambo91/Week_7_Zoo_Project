package example.codeclan.com.zooproject.ZooManagement;

import java.util.ArrayList;

import example.codeclan.com.zooproject.People.ShopWorker;
import example.codeclan.com.zooproject.People.Visitor;

/**
 * Created by user on 26/04/2017.
 */

public abstract class Shop {
    private String name;
    private int shopFunds;
    private boolean open;
    private ShopWorker[] staff;
    private ArrayList<Visitor> queue;
    private double buildPrice;
    private double stockPrice;
    private ArrayList<String> log;

    public Shop(String name, double buildPrice, double stockPrice){
        this.name = name;
        this.shopFunds = 500;
        this.open = false;
        this.staff = new ShopWorker[1];
        this.queue = new ArrayList<>();
        this.buildPrice = buildPrice;
        this.stockPrice = stockPrice;
        this.log = new ArrayList<String>();
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public double getShopFunds(){
        return shopFunds;
    }

    public void addShopFunds(double amount){
        shopFunds += amount;
    }

    public void serveFirstPersonInQueue(){
        queue.remove(0);
    }

    public void addToQueue(Visitor visitor){
        queue.add(visitor);
    }

    protected void addToLog(String message) {
        System.out.println(message);
        this.log.add(message);
    }

    public void printLog(){
        for(String event : log){
            System.out.println(event);
        }
    }

}



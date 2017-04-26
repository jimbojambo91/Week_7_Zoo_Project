package example.codeclan.com.zooproject.ZooManagement;

import java.util.ArrayList;

import example.codeclan.com.zooproject.Edible;
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
    private ShopType shopType;

    public Shop(String name, double buildPrice, double stockPrice, ShopType shopType){
        this.name = name;
        this.shopFunds = 500;
        this.open = false;
        this.staff = new ShopWorker[1];
        this.queue = new ArrayList<>();
        this.buildPrice = buildPrice;
        this.stockPrice = stockPrice;
        this.log = new ArrayList<String>();
        this.shopType = shopType;
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

    public ArrayList<Visitor> getQueue() {
        return queue;
    }

    public int getQueueLength() {
        return queue.size();
    }

    public Visitor getFirstPerson(){ return queue.get(0); }

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

    public ShopType getShopType(){
        return shopType;
    }

    public String getShopTypeString(){
        return shopType.toString();
    }

    public String getName() {
        return name;
    }

    abstract void sell(Visitor visitor);
}



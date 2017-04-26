package example.codeclan.com.zooproject.People;

import java.util.ArrayList;

import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Food.FoodType;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.ZooManagement.Sellable;

/**
 * Created by user on 25/04/2017.
 */

public abstract class Person implements Edible {
    private char gender;
    private String firstName;
    private String secondName;
    private double wallet;
    private int nutritionalValue;
    private FoodType foodType;
    private int happiness;
    private ArrayList<String> log;
    private ArrayList<Edible> belly;
    private ArrayList<Sellable> items;



    public Person(char gender, String firstName, String secondName, double wallet,
                  int nutritionalValue, FoodType foodType, int happiness){
        this.gender = gender;
        this.firstName = firstName;
        this.secondName = secondName;
        this.wallet = wallet;
        this.nutritionalValue = nutritionalValue;
        this.foodType = foodType;
        this.happiness = happiness;
        this.log = new ArrayList<String>();
        this.belly = new ArrayList<Edible>();
        this.items = new ArrayList<Sellable>();
    }

    public String getName() {
        return firstName + " " + secondName;
    }

    public double getWallet() {
        return wallet;
    }

    public String getsEaten(){
        return getName();
    }

    public final FoodType getFoodType() {
        return foodType;
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }

    public char getGender() {
        return gender;
    }

    public int getHappiness(){
        return happiness;
    }

    public void setHappiness(int newHappiness) {
        happiness = newHappiness;
    }

    public void addToHappiness(int add){
        int newHappiness = (getHappiness() + add);
        if(newHappiness > 100){
            newHappiness = 100;
        }
        setHappiness(newHappiness);
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

    public void setWallet(double amount){
        wallet = amount;
    }



    public void amendWallet(double amount){
        double wallet = getWallet();
        double newWallet = wallet + amount;
        setWallet(newWallet);
    }


    public void visit(Enclosure enclosure) {

    }

    public ArrayList<Sellable> getItems() {
        return items;
    }

    public void addToItems(Sellable sellable) {
        items.add(sellable);
    }
}



package example.codeclan.com.zooproject;

import java.util.ArrayList;

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



}



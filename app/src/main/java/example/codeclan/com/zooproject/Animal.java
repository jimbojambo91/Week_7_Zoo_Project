package example.codeclan.com.zooproject;

import java.util.ArrayList;

/**
 * Created by user on 20/04/2017.
 */

abstract class Animal implements Edible {
    private String name;
    private FoodType foodType;
    private int nutritionalValue;
    private char gender;
    private ArrayList<Edible> belly;
    private boolean mature;
    private Biome preferredBiome;
    private boolean solitary;
    private int hunger;
    private int happiness;

    public Animal(String name, FoodType foodType, char gender, boolean mature,
                  Biome preferredBiome, boolean solitary, int nutritionalValue){
        this.name = name;
        this.foodType = foodType;
        this.nutritionalValue = nutritionalValue;
        this.gender = gender;
        this.mature = mature;
        this.preferredBiome = preferredBiome;
        this.solitary = solitary;
        this.hunger = 100;
        this.happiness = 50;
        this.belly = new ArrayList<Edible>();

    }

    public final String getName() {
        return name;
    }

    public final FoodType getFoodType() {
        return foodType;
    }

    public final char getGender() {
        return gender;
    }

    public final boolean getMaturity() {
        return mature;
    }

    public final Biome getPreferredBiome() {
        return preferredBiome;
    }

    public final boolean getSolitary() {
        return solitary;
    }

    public int getHunger() {
        return hunger;
    }

    public int setHunger(int newHunger) {
        hunger = newHunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public ArrayList<Edible> getBelly() {
        return belly;
    }

    public int bellyCount() {
        return belly.size();
    }

    public String getsEaten(){
        return getName();
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }

    public void addToHunger(int add){
        int newHunger = (getHunger() + add);
        setHunger(newHunger);
    }

    abstract void eat(Edible edible);
}

package example.codeclan.com.zooproject.Animals;

import java.io.Serializable;
import java.util.ArrayList;

import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.Food.*;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.FoodType;
import example.codeclan.com.zooproject.Poop;

/**
 * Created by user on 20/04/2017.
 */

public abstract class Animal implements Edible, Serializable {
    private int id;
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
    private Enclosure currentEnclosure;
    private ArrayList<String> animalLog;
    private int preferredSpace;
    private ZooFood preferredFood;

    public Animal(String name, FoodType foodType, char gender, boolean mature,
                  Biome preferredBiome, boolean solitary, int nutritionalValue, int preferredSpace,
                  ZooFood preferredFood){
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
        this.animalLog = new ArrayList<String>();
        this.preferredSpace = preferredSpace;
        this.preferredFood = preferredFood;

    }

    // getting ID
    public int getID(){
        return this.id;
    }

    // setting id
    public void setID(int id){
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public final FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType){
        this.foodType = FoodType.valueOf(foodType);
    }

    public final char getGender() {
        return gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public final boolean getMaturity() {
        return mature;
    }

    public void setMature(boolean mature){
        this.mature = mature;
    }

    public final Biome getPreferredBiome() {
        return preferredBiome;
    }

    public void setPreferredBiome(String preferredBiome){
        this.preferredBiome = Biome.valueOf(preferredBiome);
    }

    public final boolean getSolitary() {
        return solitary;
    }

    public void setSolitary(boolean solitary){
        this.solitary = solitary;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int newHunger) {
        hunger = newHunger;
    }

    public int getHappiness() {
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

    public ArrayList<Edible> getBelly() {
        return belly;
    }

    public ArrayList<String> getAnimalLog() {
        return animalLog;
    }

    public void printAnimalLog(){
        for(String event : animalLog){
            System.out.println(event);
        }
    }

    public int bellyCount() {
        return belly.size();
    }

    public String getsEaten(){
        return getName() + " the " + getClass().getSimpleName().toString();
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }

    public void addToHunger(int add){
        int newHunger = (getHunger() + add);
        if(newHunger > 100){
            newHunger = 100;
        }
        setHunger(newHunger);
        if(newHunger < 50) {
            eat(findFood());
        }
    }

    abstract void eat(Edible edible);

    public void sleep(){
        addToHunger(-50);
        String event = getName() + " the " + getClass().getSimpleName().toString() + " went to sleep";
        getAnimalLog().add(event);
    }

    public void poop(){
        addToHunger(-25);
        getBelly().clear();
        Poop poop = new Poop();
        getAnimalEnclosure().getEnclosureFloor().add(poop);
        getAnimalEnclosure().checkPoopLevels();
        String event = getName() + " the " + getClass().getSimpleName().toString() + " pooped";
        getAnimalLog().add(event);
    }

    public Enclosure getAnimalEnclosure(){
        return currentEnclosure;
    }

    public void setEnclosureToAnimal(Enclosure enclosure){
        currentEnclosure = enclosure;
    }


    public int getPreferredSpace() {
        return preferredSpace;
    }

    public Edible findFood(){
            return getAnimalEnclosure().getAvailableFood().get(1);
    }

    public ZooFood getPreferredFood() {
        return preferredFood;
    }
}

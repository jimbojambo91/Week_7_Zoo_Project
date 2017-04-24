package example.codeclan.com.zooproject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 20/04/2017.
 */

public class Visitor implements Edible{
    private char gender;
    private String firstName;
    private String secondName;
    private double customerFunds;
    private String favouriteAnimal;
    private int nutritionalValue;
    private FoodType foodType;

    public Visitor(){
        this.gender = randomiser(genders).charAt(0);
        if(this.gender == 'M'){
            this.firstName = randomiser(firstNamesMale);
        }
        if(this.gender == 'F'){
            this.firstName = randomiser(firstNamesFemale);
        }
        this.secondName = randomiser(secondNames);
        this.customerFunds = Double.parseDouble(randomiser(amounts));
        this.favouriteAnimal = randomiser(animals);
        this.nutritionalValue = 50;
        this.foodType = FoodType.MEAT;
    }

    private static String[] genders = {
            "M", "F"
    };

    private static String[] animals = {
            "Tiger", "Lion", "Giraffe", "Bear", "Goat", "Elephant", "Emu", "Snake",
            "Wolf", "Badger", "Camel", "Crocodile", "Eagle", "Gazelle", "Jaguar"
    };

    private static String[] firstNamesMale = {
            "James", "Oliver", "Jack", "Harry", "George", "Jacob", "Charlie", "Noah",
            "William", "Thomas", "Oscar"
    };

    private static String[] firstNamesFemale = {
            "Emma", "Olivia", "Sophia", "Ava",
            "Isabella", "Mia", "Abigail", "Emily", "Charlotte", "Harper",
    };

    private static String[] secondNames = {
            "Duncan", "Smith", "Jones", "Taylor", "Williams", "Brown", "Davies",
            "Evans", "Wilson", "Thomas", "Roberts"
    };

    private static String[] amounts = {
            "100", "110", "120", "130", "140", "200", "500", "170", "300", "220"
    };

    public String randomiser(String[] names){
        Random rand = new Random();
        int listSize = names.length;
        int index = rand.nextInt(listSize);
        String selectedName = names[index];
        return selectedName;
    }

    public String getName() {
        return firstName + " " + secondName;
    }

    public double getCustomerFunds() {
        return customerFunds;
    }

    public String getFavouriteAnimal() {
        return favouriteAnimal;
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
}

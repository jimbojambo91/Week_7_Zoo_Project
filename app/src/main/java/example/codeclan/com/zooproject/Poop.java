package example.codeclan.com.zooproject;

import example.codeclan.com.zooproject.Food.FoodType;

/**
 * Created by user on 23/04/2017.
 */

public class Poop implements Edible {
    private FoodType foodType;
    private int nutritionalValue;

    public Poop(){
        foodType = FoodType.TOXIC;
        nutritionalValue = -20;
    }

    public String getsEaten(){
        return "";
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }

    public FoodType getFoodType(){
        return foodType;
    }
}

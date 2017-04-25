package example.codeclan.com.zooproject.Food;

import example.codeclan.com.zooproject.Edible;

/**
 * Created by user on 25/04/2017.
 */

public class FishBucket implements Edible {
    private FoodType foodType;
    private int nutritionalValue;

    public FishBucket(){
        foodType = FoodType.MEAT;
        nutritionalValue = 15;
    }
    public String getsEaten(){
        return "a bucket of fish";
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }

    public FoodType getFoodType(){
        return foodType;
    }
}

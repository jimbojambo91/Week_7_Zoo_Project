package example.codeclan.com.zooproject.Food;

import example.codeclan.com.zooproject.Edible;

/**
 * Created by user on 21/04/2017.
 */

public class Grass implements Edible {
    private FoodType foodType;
    private int nutritionalValue;

    public Grass(){
        foodType = FoodType.VEGETATION;
        nutritionalValue = 15;
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

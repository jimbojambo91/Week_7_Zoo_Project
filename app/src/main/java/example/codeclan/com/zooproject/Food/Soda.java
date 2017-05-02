package example.codeclan.com.zooproject.Food;

import example.codeclan.com.zooproject.Drinkable;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.ZooManagement.Sellable;
import example.codeclan.com.zooproject.ZooManagement.SellableType;

/**
 * Created by user on 26/04/2017.
 */

public class Soda implements Drinkable, Edible, Sellable {

    private FoodType foodType;
    private int nutritionalValue;
    private SellableType sellableType;

    public Soda(){
        foodType = FoodType.HUMAN;
        nutritionalValue = 15;
        sellableType = SellableType.DRINK;
    }
    public String getsEaten(){
        return "a soda";
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }

    public FoodType getFoodType(){
        return foodType;
    }

    public SellableType getSellableType(){
        return sellableType;
    }
}

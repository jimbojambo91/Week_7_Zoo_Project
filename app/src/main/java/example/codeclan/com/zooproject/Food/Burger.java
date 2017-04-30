package example.codeclan.com.zooproject.Food;

import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.ZooManagement.Sellable;
import example.codeclan.com.zooproject.ZooManagement.SellableType;

/**
 * Created by user on 26/04/2017.
 */

public class Burger implements Edible, Sellable {

    private FoodType foodType;
    private int nutritionalValue;
    private SellableType sellableType;

    public Burger(){
        foodType = FoodType.HUMAN;
        nutritionalValue = 15;
        sellableType = SellableType.FOOD;
    }
    public String getsEaten(){
        return "a burger";
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

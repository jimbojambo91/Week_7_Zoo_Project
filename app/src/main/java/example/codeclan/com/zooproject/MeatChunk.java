package example.codeclan.com.zooproject;

/**
 * Created by user on 24/04/2017.
 */

public class MeatChunk implements Edible {
    private FoodType foodType;
    private int nutritionalValue;

    public MeatChunk(){
        foodType = FoodType.MEAT;
        nutritionalValue = 15;
    }
    public String getsEaten(){
        return "a Meat Chunk";
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }

    public FoodType getFoodType(){
        return foodType;
    }
}

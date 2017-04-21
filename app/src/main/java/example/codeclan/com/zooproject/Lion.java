package example.codeclan.com.zooproject;

/**
 * Created by user on 21/04/2017.
 */

public class Lion extends Carnivore implements Edible {

    public Lion(String name, FoodType foodType, char gender, boolean mature, Biome preferredBiome, boolean solitary) {
        super(name, foodType, gender, mature, preferredBiome, solitary, 10);
    }

    public String getsEaten(){
        return "";
    }

    public int getNutritionalValue(){
        return 1;
    }
}

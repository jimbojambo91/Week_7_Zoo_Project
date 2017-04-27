package example.codeclan.com.zooproject.Animals;

import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Food.ZooFood;
import example.codeclan.com.zooproject.Food.FoodType;

/**
 * Created by user on 21/04/2017.
 */

public class Lion extends Carnivore implements Edible {

    public Lion(String name, FoodType foodType, int nutritionalValue,  char gender, boolean mature,
                Biome preferredBiome, boolean solitary, int hunger, int happiness, int preferredSpace,
                ZooFood preferredFood, int strength, double price) {
        super(name, foodType, gender, mature, preferredBiome, solitary, nutritionalValue,
                preferredSpace, preferredFood, strength,
                  price);
    }

}

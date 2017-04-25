package example.codeclan.com.zooproject.Animals;

import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Food.ZooFood;
import example.codeclan.com.zooproject.Food.FoodType;

/**
 * Created by user on 21/04/2017.
 */

public class Lion extends Carnivore implements Edible {

    public Lion(String name, char gender, boolean mature, boolean solitary) {
        super(name, FoodType.MEAT, gender, mature, Biome.SAVANNAH, solitary, 10, 25,
                ZooFood.MEATCHUNK, 50);
    }

}

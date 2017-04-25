package example.codeclan.com.zooproject.Animals;

import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.Food.ZooFood;
import example.codeclan.com.zooproject.FoodType;
import example.codeclan.com.zooproject.Grass;

/**
 * Created by user on 21/04/2017.
 */

public class Gazelle extends Herbivore{

    public Gazelle(String name, FoodType foodType, char gender, boolean mature, boolean solitary) {
        super(name, foodType, gender, mature, Biome.SAVANNAH, solitary, 30, 10, ZooFood.GRASS);
    }

}

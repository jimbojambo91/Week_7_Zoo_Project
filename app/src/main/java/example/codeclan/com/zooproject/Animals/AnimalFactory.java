package example.codeclan.com.zooproject.Animals;


import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.Food.FoodType;
import example.codeclan.com.zooproject.Food.Soda;
import example.codeclan.com.zooproject.Food.ZooFood;
import example.codeclan.com.zooproject.ZooManagement.ZooAnimals;

/**
 * Created by user on 27/04/2017.
 */

public class AnimalFactory {

    public static Animal CreateAnimal(ZooAnimals animal, String name, char gender, boolean mature,
                                      double price) {
        switch (animal.toString()) {
            case ("LION"):
                return new Lion(name, FoodType.MEAT, 50, gender, mature, Biome.SAVANNAH, false, 75, 75, 25,
                        ZooFood.MEATCHUNK, 50, price);
            case("GAZELLE"):
                return new Gazelle(name,FoodType.MEAT, 30, gender, mature, Biome.SAVANNAH, false,
                        75, 75, 25, ZooFood.GRASS, 20, price);
        }
        return null;
    }
}

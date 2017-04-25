package example.codeclan.com.zooproject.Animals;

import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.FoodType;

/**
 * Created by user on 21/04/2017.
 */

public class Carnivore extends Animal {
    public Carnivore(String name, FoodType foodType, char gender, boolean mature,
                     Biome preferredBiome, boolean solitary, int nutrionalValue, int preferredSpace,
                     Edible preferredFood) {
        super(name, foodType, gender, mature, preferredBiome, solitary, nutrionalValue, preferredSpace,
                preferredFood);
    }

    public void eat(Edible edible){
        if(edible.getFoodType() == FoodType.MEAT){
            getBelly().add(edible);
            addToHunger(edible.getNutritionalValue());
            if(bellyCount() > 4){
                poop();
            }
            String event = getName() + " the " + getClass().getSimpleName().toString() + " ate " + edible.getsEaten();
            getAnimalLog().add(event);
        }

    }
}

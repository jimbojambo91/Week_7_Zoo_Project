package example.codeclan.com.zooproject.Animals;

import java.util.ArrayList;

import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Food.ZooFood;
import example.codeclan.com.zooproject.Food.FoodType;

/**
 * Created by user on 21/04/2017.
 */

public class Carnivore extends Animal {
    public Carnivore(String name, FoodType foodType, char gender, boolean mature,
                     Biome preferredBiome, boolean solitary, int nutrionalValue, int preferredSpace,
                     ZooFood preferredFood, int strength, double price) {
        super(name, foodType, gender, mature, preferredBiome, solitary, nutrionalValue, preferredSpace,
                preferredFood, strength, price);
    }

    public void eat(Edible edible){
        if(edible == null){
            String event = "Animals in " + this.getAnimalEnclosure().getName() + " have no food";
            addToAnimalLog(event);
            return;
        }
        if(edible.getFoodType() == FoodType.MEAT){
            getBelly().add(edible);
            addToHunger(edible.getNutritionalValue());
            if(bellyCount() > 4){
                poop();
            }
            String event = getName() + " the " + getClass().getSimpleName().toString() + " ate " + edible.getsEaten();
            addToAnimalLog(event);
        }
    }

    public Edible hunt() {
        ArrayList<Animal> animals = getAnimalEnclosure().getAnimals();
        for (Animal animal : animals) {
            if (animal.getStrength() < (this.getStrength() - 10)) {
                return animal;
            }
        }
        return null;
    }
}

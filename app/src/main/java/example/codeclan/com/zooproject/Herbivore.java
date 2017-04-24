package example.codeclan.com.zooproject;

/**
 * Created by user on 21/04/2017.
 */

public class Herbivore extends Animal {
    public Herbivore(String name, FoodType foodType, char gender, boolean mature, Biome preferredBiome, boolean solitary, int nutrionalValue, int preferredSpace) {
        super(name, foodType, gender, mature, preferredBiome, solitary, nutrionalValue, preferredSpace);
    }

    public void eat(Edible edible){
        if(edible.getFoodType() == FoodType.VEGETATION){
            getBelly().add(edible);
            addToHunger(edible.getNutritionalValue());
            if(bellyCount() > 4){
                poop();
            }
            String event = getName() + " the " + getClass().getSimpleName().toString() + " ate " + edible;
            getAnimalLog().add(event);
        }

    }
}

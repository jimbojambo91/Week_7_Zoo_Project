package example.codeclan.com.zooproject.People;

import example.codeclan.com.zooproject.Animals.Animal;
import example.codeclan.com.zooproject.Food.ZooFood;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.FoodType;

/**
 * Created by user on 25/04/2017.
 */

public class ZooKeeper extends Staff {

    ZooKeeper(char gender, String firstName, String secondName, double wallet,
              int nutritionalValue, FoodType foodType, int happiness){
        super(gender, firstName, secondName, wallet, nutritionalValue, foodType, happiness);
    }

    public void clean(Enclosure enclosure) {
        addToLog("Cleaned: " + enclosure.getName());
        enclosure.getEnclosureFloor().clear();
    }


    public void feed(Enclosure enclosure) {
        for(Animal animal : enclosure.getAnimals()){
            ZooFood preferredFood = animal.getPreferredFood();
            // food = create new instance of that food (make zoo pay for it?)
            enclosure.addFood(food);
        }
        addToLog("Fed animals in" + enclosure.getName());
    }
}

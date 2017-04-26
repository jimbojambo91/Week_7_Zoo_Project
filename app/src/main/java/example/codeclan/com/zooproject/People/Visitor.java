package example.codeclan.com.zooproject.People;

import example.codeclan.com.zooproject.Animals.Animal;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Food.FoodType;
import example.codeclan.com.zooproject.ZooManagement.Eatable;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.ZooManagement.Sellable;

/**
 * Created by user on 20/04/2017.
 */

public class Visitor extends Person{

    private String favouriteAnimal;
    private int hunger;
    private int thirst;


    Visitor(char gender, String firstName, String secondName, double wallet, String favouriteAnimal,
            int nutritionalValue, FoodType foodType, int happiness, int hunger, int thirst){
        super(gender, firstName, secondName, wallet, nutritionalValue, foodType, happiness);
        this.favouriteAnimal = favouriteAnimal;
        this.hunger = hunger;
        this.thirst = thirst;
    }

    public String getFavouriteAnimal() {
        return favouriteAnimal;
    }

    public String getsEaten(){

        return getName();
    }
    
    public void visit(Enclosure enclosure){
        enclosure.addToViewingGallery(this);
        addToLog("Visited " + enclosure.getName());
        addToThirst(-10);
        addToHunger(-10);
        watchAnimals(enclosure);
        enclosure.removeFromViewingGallery(this);
    }

    private void watchAnimals(Enclosure enclosure) {
        for(Animal animal : enclosure.getAnimals()){
            addToLog("Seen " + animal.getClass().getSimpleName() + " in " + enclosure.getName());
            if(animal.getClass().getSimpleName().toString().equals(this.favouriteAnimal)){
                addToHappiness(25);
                addToLog("Wow a " + animal.getClass().getSimpleName() + " that's my favourite!" );
            }
        }
    }

    public void addToThirst(int value) {
        thirst += value;
    }

    public void addToHunger(int value) {
        hunger += value;
    }

    public int getThirst() {
        return thirst;
    }

    public int getHunger() {
        return hunger;
    }


}

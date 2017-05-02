package example.codeclan.com.zooproject.People;

import example.codeclan.com.zooproject.Animals.Animal;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Food.FoodType;
import example.codeclan.com.zooproject.ZooManagement.Eatable;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.ZooManagement.Sellable;
import example.codeclan.com.zooproject.ZooManagement.SellableType;
import example.codeclan.com.zooproject.ZooManagement.Shop;

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

    public void visit(Shop shop){
        shop.addToQueue(this);
        addToLog("In Line for " + shop.getName());
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

    public void leave() {
        if(getWallet() < 10){
            addToLog("I have no money left. Time to go home.");
        }
        if(getHappiness() < 20){
            addToLog("This zoo is no fun! I'm going home!");
        }
        else {
            addToHappiness(-100);
            addToLog(("This zoo has no Enclosures!!! I'm going home!"));
        }

    }

    public void eatFirstEdible() {
        for(Sellable item : getItems()){
            if(item.getSellableType() == SellableType.FOOD){
                Edible edibleItem = (Edible) item;
                addToLog("Ate " + edibleItem.getsEaten());
                this.addToHunger(edibleItem.getNutritionalValue());
                this.addToBelly(edibleItem);
                this.removeItem(item);
                break;
            }
        }
    }

    public void DrinkFirstEdible() {
        for(Sellable item : getItems()){
            if(item.getSellableType() == SellableType.DRINK){
                Edible edibleItem = (Edible) item;
                addToLog("Drank " + edibleItem.getsEaten());
                this.addToThirst(edibleItem.getNutritionalValue());
                this.addToBelly(edibleItem);
                this.removeItem(item);
                break;
            }
        }
    }
}

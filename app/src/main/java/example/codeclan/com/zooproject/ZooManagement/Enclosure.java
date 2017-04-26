package example.codeclan.com.zooproject.ZooManagement;

import java.util.ArrayList;

import example.codeclan.com.zooproject.Animals.Animal;
import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Poop;

/**
 * Created by user on 20/04/2017.
 */

public class Enclosure {
    private String name;
    private int plotSize;
    private Biome biome;
    private ArrayList<Animal> animals;
    private ArrayList<Edible> availableFood;
    private ArrayList<Poop> enclosureFloor;

    public Enclosure(String name, int plotSize, Biome biome){
        this.name = name;
        this.plotSize = plotSize;
        this.biome = biome;
        this.animals = new ArrayList<Animal>();
        this.availableFood = new ArrayList<Edible>();
        this.enclosureFloor = new ArrayList<Poop>();
    }

    public String getName() {
        return name;
    }

    public int getPlotSize() {
        return plotSize;
    }

    public Biome getBiome() {
        return biome;
    }

    public ArrayList<Edible> getAvailableFood(){
        return availableFood;
    }

    public ArrayList<Animal> getAnimals() { return animals; }

    public int getAvailableFoodCount(){
        return availableFood.size();
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.setEnclosureToAnimal(this);
        checkSpace();
        checkBiome(animal);
        checkCompatability(animal);
    }

    private void checkBiome(Animal animal) {
        if(this.getBiome() != animal.getPreferredBiome()){
            animal.addToHappiness(-25);
            System.out.println(animal.getName() + " the " + animal.getClass().getSimpleName() +
            " is in the wrong Biome! This will lead to unhappiness.");
        }
        else return;
    }

    private void checkCompatability(Animal animal) {
        if (animals.size() == 1){
            return;
        }
        else if(animals.size() > 1){
            int counter = 0;
            for(Animal loopedAnimal : animals){
                if(loopedAnimal.getSolitary() == true){
                    counter ++;
                }
            }
            if(counter ==0){
                return;
            }
        }

    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void addFood(Edible edible) {
        availableFood.add(edible);
    }

    public void removeFood(Edible edible) {
        availableFood.remove(edible);
    }

    public ArrayList<Poop> getEnclosureFloor() {
        return enclosureFloor;
    }

    public void checkPoopLevels() {
        if(enclosureFloor.size() > 4){
            for( Animal animal : animals){
                animal.addToHappiness(-20);
            }
            System.out.println("There is too much poop in " + getName() + ". Send a Zoo Keeper to help ");
        }
    }

    public void checkSpace(){
        int usedSpace = 0;
        int availableSpace = getPlotSize();
        for(Animal animal : animals){
            usedSpace += animal.getPreferredSpace();
        }
        if(usedSpace > availableSpace) {
            for( Animal animal : animals){
                animal.addToHappiness(-10);
            }
            System.out.println("Animals in " + getName() + " don't have enough space. Consider" +
                    " moving an animal or expanding Enclosure. ");

        }
    }
}

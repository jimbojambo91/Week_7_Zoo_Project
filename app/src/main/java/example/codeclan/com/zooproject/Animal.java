package example.codeclan.com.zooproject;

import java.util.ArrayList;

/**
 * Created by user on 20/04/2017.
 */

public class Animal {
    private String name;
    private String type;
    private char gender;
    private ArrayList<Edible> belly;
    private boolean mature;
    private Biome preferredBiome;
    private boolean solitary;
    private int hunger;
    private int happiness;

    public Animal(String name, String type, char gender, boolean mature,
                  Biome preferredBiome, boolean solitary){
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.mature = mature;
        this.preferredBiome = preferredBiome;
        this.solitary = solitary;
        this.hunger = 100;
        this.happiness = 50;
        this.belly = new ArrayList<Edible>();

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public char getGender() {
        return gender;
    }

    public boolean getMaturity() {
        return mature;
    }

    public Biome getPreferredBiome() {
        return preferredBiome;
    }

    public boolean getSolitary() {
        return solitary;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }
}

package example.codeclan.com.zooproject;

import android.view.View;

import java.util.ArrayList;
import java.util.Random;

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
}

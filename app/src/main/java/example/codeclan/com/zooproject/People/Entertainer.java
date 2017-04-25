package example.codeclan.com.zooproject.People;

import example.codeclan.com.zooproject.Food.FoodType;

/**
 * Created by user on 25/04/2017.
 */

public class Entertainer extends Staff {

    private String costume;

    Entertainer(char gender, String firstName, String secondName, double wallet,
                int nutritionalValue, FoodType foodType, int happiness, String costume){
        super(gender, firstName, secondName, wallet, nutritionalValue, foodType, happiness);
        this.costume = costume;
    }
}

package example.codeclan.com.zooproject.People;

import example.codeclan.com.zooproject.Food.FoodType;

/**
 * Created by user on 25/04/2017.
 */

public abstract class Staff extends Person {

    Staff(char gender, String firstName, String secondName, double wallet,
          int nutritionalValue, FoodType foodType, int happiness){
        super(gender, firstName, secondName, wallet, nutritionalValue, foodType, happiness);
    }


}

package example.codeclan.com.zooproject;

import java.util.ArrayList;

/**
 * Created by user on 20/04/2017.
 */

public class Visitor implements Edible{
    private String name;
    private double customerFunds;
    private String favouriteAnimal;
    private int nutritionalValue;

    public Visitor(String name, double customerFunds, String favouriteAnimal){
        this.name = name;
        this.customerFunds = customerFunds;
        this.favouriteAnimal = favouriteAnimal;
        this.nutritionalValue = 5;
    }

    public String getName() {
        return name;
    }

    public double getCustomerFunds() {
        return customerFunds;
    }

    public String getFavouriteAnimal() {
        return favouriteAnimal;
    }

    public String getsEaten(){
        return getName();
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }
}

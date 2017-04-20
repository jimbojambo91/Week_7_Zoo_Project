package example.codeclan.com.zooproject;

import java.util.ArrayList;

/**
 * Created by user on 20/04/2017.
 */

public class Visitor {
    private String name;
    private double customerFunds;
    private String favouriteAnimal;

    public Visitor(String name, double customerFunds, String favouriteAnimal){
        this.name = name;
        this.customerFunds = customerFunds;
        this.favouriteAnimal = favouriteAnimal;
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
}

package example.codeclan.com.zooproject.People;

import example.codeclan.com.zooproject.Food.FoodType;
import example.codeclan.com.zooproject.ZooManagement.Shop;

/**
 * Created by user on 26/04/2017.
 */

public class ShopWorker extends Staff {

    private Shop currentWorkPlace;

    ShopWorker(char gender, String firstName, String secondName, double wallet,
                int nutritionalValue, FoodType foodType, int happiness) {
        super(gender, firstName, secondName, wallet, nutritionalValue, foodType, happiness);
    }

    public Shop getCurrentWorkPlace() {
        return currentWorkPlace;
    }

    public boolean hasCurrentWorkPlace() {
        if(getCurrentWorkPlace() == null){
            return false;
        }
        else return true;
    }

    public void setCurrentWorkPlace(Shop currentWorkPlace) {
        this.currentWorkPlace = currentWorkPlace;
    }
}

package example.codeclan.com.zooproject.Food;

import example.codeclan.com.zooproject.Drinkable;
import example.codeclan.com.zooproject.Edible;

/**
 * Created by user on 26/04/2017.
 */

public class DrinkableFactory {

    public static Drinkable createDrinkable(ZooFood zooFood) {
        switch (zooFood.toString()) {
            case("SODA"): return new Soda();
        }
        return null;
    }
}

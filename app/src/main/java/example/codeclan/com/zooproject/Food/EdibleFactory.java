package example.codeclan.com.zooproject.Food;

import example.codeclan.com.zooproject.Edible;

/**
 * Created by user on 25/04/2017.
 */

public class EdibleFactory {

    public static Edible createEdible(ZooFood zooFood){
        switch(zooFood.toString()){
            case("MEATCHUNK"): return new MeatChunk();
            case("GRASS"): return new Grass();
            case("FISH"): return new FishBucket();
            case("BURGER"): return new Burger();
        }
        return null;

    }
}

package example.codeclan.com.zooproject.Food;

import example.codeclan.com.zooproject.FoodType;
import example.codeclan.com.zooproject.MeatChunk;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.Grass;
import example.codeclan.com.zooproject.People.Visitor;

/**
 * Created by user on 25/04/2017.
 */

public class EdibleFactory {

    public static Edible createEdible(ZooFood zooFood){
        switch(zooFood.toString()){
            case("MEATCHUNK"): return new MeatChunk();
            case("GRASS"): return new Grass();
            case("FISH"): return new Fish();
        }

    }
}

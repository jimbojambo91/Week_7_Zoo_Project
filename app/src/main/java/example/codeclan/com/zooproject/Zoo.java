package example.codeclan.com.zooproject;

import java.util.ArrayList;

/**
 * Created by user on 20/04/2017.
 */

public class Zoo {
    private String name;
    private ArrayList<Enclosure> enclosures;
    private double zooFunds;
    private ArrayList<Visitor> visitors;

    public Zoo(String name, double zooFunds){
        this.name = name;
        this.enclosures = new ArrayList<Enclosure>();
        this.zooFunds = zooFunds;
        this.visitors = new ArrayList<Visitor>();
    }


    public String getName() {
        return name;
    }

    public double getZooFunds() {
        return zooFunds;
    }
}

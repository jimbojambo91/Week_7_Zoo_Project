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

    public int getEnclosureCount() {
        return enclosures.size();
    }

    public void addEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    public void removeEnclosure(Enclosure enclosure) {
        enclosures.remove(enclosure);
    }


    public Enclosure findEnclosureByName(String enclosureName) {
        for(Enclosure enclosure : enclosures){
            if(enclosure.getName().equals(enclosureName)){
                return enclosure;
            }
        }
        return null;
    }
}

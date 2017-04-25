package example.codeclan.com.zooproject.ZooManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import example.codeclan.com.zooproject.People.Entertainer;
import example.codeclan.com.zooproject.People.PersonFactory;
import example.codeclan.com.zooproject.People.Staff;
import example.codeclan.com.zooproject.People.Visitor;
import example.codeclan.com.zooproject.People.ZooKeeper;

/**
 * Created by user on 20/04/2017.
 */

public class Zoo {
    private String name;
    private ArrayList<Enclosure> enclosures;
    private double zooFunds;
    private ArrayList<Visitor> visitors;
    private HashMap<Staff, Double> salaries;

    public Zoo(String name, double zooFunds){
        this.name = name;
        this.enclosures = new ArrayList<Enclosure>();
        this.zooFunds = zooFunds;
        this.visitors = new ArrayList<Visitor>();
        this.salaries = new HashMap<Staff, Double>();
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

    public int getVisitorCount() {
        return visitors.size();
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public void removeVisitor(Visitor visitor) {
        visitors.remove(visitor);
    }

    public void setZooFunds(double amount){
        zooFunds = amount;
    }

    public void amendZooFunds(double amount){
        double zf = getZooFunds();
        double newZooFunds = zf + amount;
        setZooFunds(newZooFunds);
    }


    public Enclosure findEnclosureByName(String enclosureName) {
        for(Enclosure enclosure : enclosures){
            if(enclosure.getName().equals(enclosureName)){
                return enclosure;
            }
        }
        return null;
    }

    public void addToSalaries(Staff staff, Double salary){
        salaries.put(staff, salary);
    }

    public int totalStaffCount(){
            return salaries.size();
        }

    public void hireZooKeeper() {
        ZooKeeper zookeeper = PersonFactory.getRandomZooKeeper();
        addToSalaries(zookeeper, 300.00);
    }

    public void hireEntertainer() {
        Entertainer entertainer = PersonFactory.getRandomEntertainer();
        addToSalaries(entertainer, 100.00);
    }

    public void payStaff() {
        Set<Staff> keys = salaries.keySet();
        for(Staff key : keys ){
            double salary = salaries.get(key);
            key.amendWallet(salary);
            this.amendZooFunds(-salary);
        }
    }

    public void fireStaff(Staff staff){
        salaries.remove(staff);
    }

    public void sellTicket(Visitor visitor) {
        visitor.amendWallet(-15);
        this.amendZooFunds(15);
        addVisitor(visitor);

    }
}


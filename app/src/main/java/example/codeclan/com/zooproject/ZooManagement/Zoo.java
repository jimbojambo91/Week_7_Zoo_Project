package example.codeclan.com.zooproject.ZooManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import example.codeclan.com.zooproject.Animals.Animal;
import example.codeclan.com.zooproject.Animals.AnimalFactory;
import example.codeclan.com.zooproject.Animals.Gazelle;
import example.codeclan.com.zooproject.Biome;
import example.codeclan.com.zooproject.People.Entertainer;
import example.codeclan.com.zooproject.People.PersonFactory;
import example.codeclan.com.zooproject.People.ShopWorker;
import example.codeclan.com.zooproject.People.Staff;
import example.codeclan.com.zooproject.People.Visitor;
import example.codeclan.com.zooproject.People.ZooKeeper;

/**
 * Created by user on 20/04/2017.
 */

public class Zoo {
    private String name;
    private ArrayList<Enclosure> enclosures;
    private ArrayList<Shop> shops;
    private double zooFunds;
    private ArrayList<Visitor> visitors;
    private HashMap<Staff, Double> salaries;
    private ArrayList<Visitor> entrancePath;
    private ArrayList<Visitor> exitPath;
    private ArrayList<String> log;
    private ArrayList<Animal> temporaryStorage;
    private HashMap<ZooAnimals, Double> animalPriceList;

    public Zoo(String name, double zooFunds){
        this.name = name;
        this.enclosures = new ArrayList<Enclosure>();
        this.shops = new ArrayList<Shop>();
        this.zooFunds = zooFunds;
        this.visitors = new ArrayList<Visitor>();
        this.salaries = new HashMap<Staff, Double>();
        this.entrancePath = new ArrayList<Visitor>();
        this.exitPath = new ArrayList<Visitor>();
        this.log = new ArrayList<String>();
        this.temporaryStorage = new ArrayList<Animal>();
        this.animalPriceList = new HashMap<>();
        fillPriceList();
    }

    private void fillPriceList() {
        animalPriceList.put(ZooAnimals.LION, 2000.00);
        animalPriceList.put(ZooAnimals.GAZELLE, 500.00);
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

    public int getShopCount() {
        return shops.size();
    }

    public void addShop(Shop shop) {
        shops.add(shop);
    }

    public void removeShop(Shop shop) {
        shops.remove(shop);
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

    public ArrayList<Animal> getTemporaryStorage(){
        return temporaryStorage;
    }

    public void addAnimalToTemporaryStorage(Animal animal) {
        temporaryStorage.add(animal);
    }

    public void removeAnimalToTemporaryStorage(Animal animal) {
        temporaryStorage.remove(animal);
    }

    protected void addToLog(String message) {
        System.out.println(message);
        this.log.add(message);
    }

    public void printLog(){
        for(String event : log){
            System.out.println(event);
        }
    }

    public void setZooFunds(double amount){
        zooFunds = amount;
    }

    public void addZooFunds(double amount){
        zooFunds += amount;
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

    public void hireShopWorker() {
        ShopWorker shopWorker = PersonFactory.getRandomShopWorker();
        addToSalaries(shopWorker, 100.00);
    }

    public double getStaffSalary(Staff staff){
        return salaries.get(staff);
    }

    public void payStaff() {
        Set<Staff> keys = salaries.keySet();
        for(Staff key : keys ){
            double salary = salaries.get(key);
            key.amendWallet(salary);
            this.addZooFunds(-salary);
        }
    }

    public void fireStaff(Staff staff){
        salaries.remove(staff);
    }

    public Enclosure randomEnclosure(){
        Random rand = new Random();
        int listSize = enclosures.size();
        int index = rand.nextInt(listSize);
        return enclosures.get(index);

    }

    public void sellTicket() {
        Visitor visitor = getFirstInZooQueue();
        visitor.amendWallet(-15);
        this.addZooFunds(15);
        entrancePath.remove(visitor);
        addVisitor(visitor);
    }

    public void sellTicket(Visitor visitor) {
        visitor.amendWallet(-15);
        this.addZooFunds(15);
        entrancePath.remove(visitor);
        addVisitor(visitor);
    }

    public boolean checkAdequateFunds(double price){
        if( zooFunds > price){
            return true;
        }
        else return false;

    }



    public void buildNewEnclosure(String name, int plotSize, Biome Biome){
        if(checkAdequateFunds(plotSize*50)){
            Enclosure enclosure = new Enclosure(name, plotSize, Biome);
            enclosures.add(enclosure);
            addZooFunds(enclosure.getBuildPrice());
            addToLog("Built new Enclosure: " + enclosure.getName());
        }
    }

    public void buildBurgerShop(String name){
        if(checkAdequateFunds(500)){
            BurgerShop newShop = new BurgerShop(name);
            shops.add(newShop);
            addZooFunds(-500);
            addToLog("Built new Burger Shop: " + newShop.getName());
        }
    }

    public void buildSodaShack(String name){
        if(checkAdequateFunds(500)){
            SodaShack newShop = new SodaShack(name);
            shops.add(newShop);
            addZooFunds(-500);
            addToLog("Built new Soda Shack: " + newShop.getName());
        }
    }

    public void updateVisitors(){
        for (Visitor visitor : visitors) {
            if (visitor.getWallet() < 10 || visitor.getHappiness() < 20) {
                visitor.leave();
                exitPath.add(visitor);
                break;
            }
            if (visitor.getHunger() < 20) {
                if(visitor.checkEdibleItem()){
                    visitor.eatFirstEdible();
                }
                if(checkOpenEatable()){
                    visitor.visit(this.getRandomEatable());
                    break;
                }
                visitor.addToHappiness(-20);
                addToLog("Visitors are Hungry!");

            }
            if (visitor.getThirst() < 20) {
                if(checkOpenThirstable()){
                    visitor.visit(this.getRandomThirstable());
                    break;
                }
                visitor.addToHappiness(-20);
                addToLog("Visitors are Thirsty!");

            }
            if(getEnclosureCount() == 0){
                visitor.leave();
                exitPath.add(visitor);
                break;
            }
            visitor.visit(this.randomEnclosure());
            break;
        }
    }

    private boolean checkOpenThirstable() {
        for(Shop shop : shops){
            if(shop.getShopTypeString().equals("DRINK") &&
                    shop.getOpen() == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOpenEatable() {
        for(Shop shop : shops){
            if(shop.getShopTypeString().equals("EAT") &&
                    shop.getOpen() == true) {
                    return true;
            }
            }
            return false;
    }

    public void updateShops(){
        for(Shop shop : shops){
            shop.checkStatus();
            if(shop.getQueueLength() != 0){
                shop.sell(shop.getFirstPerson());
            }
            else return;
        }
    }

    public void guestCreator(){
        Random rand = new Random();
        int index = rand.nextInt(5);
        if(index == 1){
            Visitor newVisitor = PersonFactory.getRandomVisitor();
            entrancePath.add(newVisitor);
        }
        else return;
    }

    public void clearExitingGuests(){
        exitPath.clear();
    }

    public void update(){
        clearExitingGuests();
        guestCreator();
        if(checkIfQueue()){
            sellTicket();
        }
        updateShops();
        updateVisitors();
    }

    public Shop getRandomEatable() {
        ArrayList<Shop> tempArrayList = new ArrayList<Shop>();
        for(Shop shop : shops){
            if(shop.getShopTypeString().equals("EAT")){
                tempArrayList.add(shop);
            }
        }
        Random rand = new Random();
        int listSize = tempArrayList.size();
        int index = rand.nextInt(listSize);
        Shop selectedValue = tempArrayList.get(index);
        return selectedValue;
    }

    public Shop getRandomThirstable() {
        ArrayList<Shop> tempArrayList = new ArrayList<Shop>();
        for(Shop shop : shops) {
            if (shop.getShopTypeString().equals("DRINK")){
                tempArrayList.add(shop);
            }
        }
        Random rand = new Random();
        int listSize = tempArrayList.size();
        int index = rand.nextInt(listSize);
        Shop selectedValue = tempArrayList.get(index);
        return selectedValue;
    }

    public ArrayList<Visitor> getExitPath() {
        return exitPath;
    }

    public int getExitPathCount() {
        return exitPath.size();
    }

    public boolean checkIfQueue(){
        if(entrancePath.size() > 0){
            return true;
        }
        else return false;
    }

    public Visitor getFirstInZooQueue() {
        if(checkIfQueue()){
            return entrancePath.get(0);
        }
        return null;

    }


    public void buyMale(ZooAnimals animal) {
        double price = animalPriceList.get(animal);
        if(checkAdequateFunds(price)){
            String count = animalCountType(animal).toString();
            String name = animal.toString() + count;
            boolean mature = true;
            char gender = 'M';
            addAnimalToTemporaryStorage(AnimalFactory.CreateAnimal(animal, name, gender, mature, price));
        }
    }

    public void buyFemale(ZooAnimals animal) {
        double price = animalPriceList.get(animal);
        if(checkAdequateFunds(price)){
            String count = animalCountType(animal).toString();
            String name = animal.toString() + count;
            boolean mature = true;
            char gender = 'F';
            addAnimalToTemporaryStorage(AnimalFactory.CreateAnimal(animal, name, gender, mature, price));
        }
    }

    private Integer animalCountType(ZooAnimals seachAnimal) {
        Integer counter = 1;
        for(Enclosure enclosure: enclosures){
            for(Animal animal: enclosure.getAnimals()){
                if(animal.getClass().getSimpleName().toString().equals(seachAnimal.toString())){
                    counter ++ ;
                }
            }

        }
        return counter;
    }


    public Enclosure getEnclosureByName(String name) {
        for(Enclosure enclosure : enclosures){
            if(enclosure.getName().equals(name)){
                return enclosure;
            }
        }
        return null;
    }

    public void placeShopWorkerInShop(Shop shop) {
        Set<Staff> keys = salaries.keySet();
        for(Staff key : keys ){
            if(key.getClass().getSimpleName().toString().equals("ShopWorker")){
                if (!key.hasCurrentWorkPlace()){
                    ShopWorker worker = (ShopWorker) key;
                    shop.addShopWorker(worker);
                    break;

                }
            }

        }
    }

    public Shop findShopByName(String name) {
        for(Shop shop : shops){
            if(shop.getName().equals(name)){
                return shop;
            }
        }
        return null;
    }
}


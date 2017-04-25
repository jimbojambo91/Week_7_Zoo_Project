package example.codeclan.com.zooproject.People;

import java.util.Random;

import example.codeclan.com.zooproject.FoodType;

/**
 * Created by user on 25/04/2017.
 */

public class PersonFactory {

    private static String randomiser(String[] values){
        Random rand = new Random();
        int listSize = values.length;
        int index = rand.nextInt(listSize);
        String selectedValue = values[index];
        return selectedValue;
    }


    public static Visitor getRandomVisitor() {
        char gender = randomiser(genders).charAt(0);
        String firstName = null;
        if(gender == 'M'){
            firstName = randomiser(firstNamesMale);
        }
        else if(gender == 'F'){
            firstName = randomiser(firstNamesFemale);
        }
        String secondName = randomiser(secondNames);
        double wallet = Double.parseDouble(randomiser(amounts));
        String favouriteAnimal = randomiser(animals);
        return new Visitor(gender, firstName, secondName, wallet, favouriteAnimal, 50
        , FoodType.MEAT, 75, 75, 75);
    }

    public static ZooKeeper getRandomZooKeeper() {
        char gender = randomiser(genders).charAt(0);
        String firstName = null;
        if(gender == 'M'){
            firstName = randomiser(firstNamesMale);
        }
        else if(gender == 'F'){
            firstName = randomiser(firstNamesFemale);
        }
        String secondName = randomiser(secondNames);
        double wallet = Double.parseDouble(randomiser(amounts));
        return new ZooKeeper(gender, firstName, secondName, wallet, 50
                , FoodType.MEAT, 75);
    }

    private static String[] genders = {
            "M", "F"
    };

    private static String[] animals = {
            "Tiger", "Lion", "Giraffe", "Bear", "Goat", "Elephant", "Emu", "Snake",
            "Wolf", "Badger", "Camel", "Crocodile", "Eagle", "Gazelle", "Jaguar"
    };

    private static String[] firstNamesMale = {
            "James", "Oliver", "Jack", "Harry", "George", "Jacob", "Charlie", "Noah",
            "William", "Thomas", "Oscar"
    };

    private static String[] firstNamesFemale = {
            "Emma", "Olivia", "Sophia", "Ava",
            "Isabella", "Mia", "Abigail", "Emily", "Charlotte", "Harper",
    };

    private static String[] secondNames = {
            "Duncan", "Smith", "Jones", "Taylor", "Williams", "Brown", "Davies",
            "Evans", "Wilson", "Thomas", "Roberts"
    };

    private static String[] amounts = {
            "100", "110", "120", "130", "140", "200", "500", "170", "300", "220"
    };
}

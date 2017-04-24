//package database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import example.codeclan.com.zooproject.Biome;
//import example.codeclan.com.zooproject.Edible;
//import example.codeclan.com.zooproject.*;
//
///**
// * Created by user on 24/04/2017.
// */
//
//public class DatabaseHandler extends SQLiteOpenHelper{
//
//    // All Static variables
//    // Database Version
//    private static final int DATABASE_VERSION = 1;
//
//    // Database Name
//    private static final String DATABASE_NAME = "zooManager";
//
//    // Contacts table name
//    private static final String TABLE_ANIMALS = "animals";
//
//    // Contacts Table Columns names
//    private static final String KEY_ID = "id";
//    private static final String KEY_NAME = "name";
//    private static final String KEY_foodType = "foodType";
//    private static final String KEY_nutritionalValue = "nutritionalValue";
//    private static final String KEY_gender = "gender";
//    private static final ArrayList<Edible> KEY_belly;
//    private static final String KEY_mature = "maturity";
//    private static final String KEY_preferredBiome = "preferredBiome";
//    private static final String KEY_solitary = "solitary";
//    private static final String KEY_hunger = "hunger";
//    private static final String KEY_happiness = "happiness";
//    private static final String KEY_currentEnclosure = "currentEnclosure";
//
//    public DatabaseHandler(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    // Creating Tables
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String CREATE_ANIMALS_TABLE = "CREATE TABLE " + TABLE_ANIMALS + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
//                + KEY_foodType + " TEXT," + KEY_nutritionalValue + " INT,"
//                + KEY_gender + " CHARACTER," + KEY_mature + " BOOLEAN,"
//                + KEY_preferredBiome + " TEXT," + KEY_solitary + " BOOLEAN,"
//                + KEY_hunger + " INT," + KEY_happiness + " INT,"
//                + KEY_currentEnclosure + "TEXT" + ")";
//        db.execSQL(CREATE_ANIMALS_TABLE);
//    }
//
//    // Upgrading database
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Drop older table if existed
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS);
//
//        // Create tables again
//        onCreate(db);
//    }
//
//    // Adding new animal
//    public void addAnimal(Animal animal) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, animal.getName()); // Animal Name
//        values.put(KEY_foodType, animal.getFoodType().toString()); // Animal FoodType
//        values.put(KEY_nutritionalValue, animal.getNutritionalValue()); // Animal NutritionalValue
//        values.put(KEY_preferredBiome, animal.getPreferredBiome().toString()); // Animal Preferred Biome
//        values.put(KEY_solitary, animal.getSolitary()); // Animal Solitary
//        values.put(KEY_hunger, animal.getHunger()); // Animal Hunger
//        values.put(KEY_happiness, animal.getHappiness()); // Animal Happiness
//        values.put(KEY_currentEnclosure, animal.getAnimalEnclosure()); // Animal Enclosure
//
//
//        // Inserting Row
//        db.insert(TABLE_ANIMALS, null, values);
//        db.close(); // Closing database connection
//    }
//
//    // Getting single contact
//    public Animal getAnimal(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_ANIMALS, new String[] { KEY_ID,
//                        KEY_NAME, KEY_foodType, KEY_nutritionalValue, KEY_preferredBiome,
//                KEY_solitary, KEY_hunger, KEY_happiness, KEY_currentEnclosure}, KEY_ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        Animal animal = new Animal(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1), FoodType.valueOf(cursor.getString(2)),
//                Integer.parseInt(cursor.getString(3)), Biome.valueOf(cursor.getString(4));
//        // return animal
//        return animal;
//    }
//
//    public List<Animal> getAllAnimals() {
//        List<Animal> AnimalList = new ArrayList<Animal>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_ANIMALS;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                Animal animal = new Animal();
//                animal.setID(Integer.parseInt(cursor.getString(0)));
//                animal.setName(cursor.getString(1));
//                animal.setFoodType(cursor.getString(2));
//                animal.setNutritionalValue(Integer.parseInt(cursor.getString(3)));
//                animal.setPreferredBiome(cursor.getString(4));
//                animal.setSolitary(cursor.getString(5));
//                animal.setHunger(cursor.getString(6));
//                animal.setHappiness(cursor.getString(7));
//                animal.setCurrentEnclosure(cursor.getString(8));
//                // Adding animal to list
//                animalList.add(animal);
//            } while (cursor.moveToNext());
//        }
//
//        // return animal list
//        return animalList;
//    }
//}

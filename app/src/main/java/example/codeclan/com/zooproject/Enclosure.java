package example.codeclan.com.zooproject;

import java.util.ArrayList;

/**
 * Created by user on 20/04/2017.
 */

public class Enclosure {
    private String name;
    private int plotSize;
    private Biome biome;
    private ArrayList<Animal> Animals;

    public Enclosure(String name, int plotSize, Biome biome){
        this.name = name;
        this.plotSize = plotSize;
        this.biome = biome;
    }

    public String getName() {
        return name;
    }

    public int getPlotSize() {
        return plotSize;
    }

    public Biome getBiome() {
        return biome;
    }
}

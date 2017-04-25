package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.Animals.Lion;
import example.codeclan.com.zooproject.People.PersonFactory;
import example.codeclan.com.zooproject.People.ZooKeeper;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 25/04/2017.
 */

public class ZooKeeperTest {

    ZooKeeper zooKeeper;
    Enclosure enclosure;
    Lion lion;

    @Before
    public void before(){
        zooKeeper = PersonFactory.getRandomZooKeeper();
        enclosure = new Enclosure("Lion House", 50, Biome.SAVANNAH);
        lion = new Lion("Harold", 'M', true, false);
    }

    @Test
    public void zooKeeperCanCleanEnclosure(){
        enclosure.addAnimal(lion);
        lion.poop();
        assertEquals(1, enclosure.getEnclosureFloor().size());
        zooKeeper.clean(enclosure);
        assertEquals(0, enclosure.getEnclosureFloor().size());
    }

    @Test
    public void zooKeeperCanFeedEnclosure(){
        enclosure.addAnimal((lion));
        assertEquals(0, enclosure.getAvailableFoodCount());
        zooKeeper.feed(enclosure);
        assertEquals(1, enclosure.getAvailableFoodCount());
        String result = enclosure.getAvailableFood().get(0).getsEaten();
        assertEquals("a Meat Chunk", result);

    }
}

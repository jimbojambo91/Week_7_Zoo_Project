package example.codeclan.com.zooproject;

import org.junit.Test;

import example.codeclan.com.zooproject.People.PersonFactory;
import example.codeclan.com.zooproject.People.ShopWorker;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 29/04/2017.
 */

public class ShopWorkerTest {

    @Test
    public void currentWorkplaceBlankOnCreateTest(){
        ShopWorker shopworker = PersonFactory.getRandomShopWorker();
        assertEquals(null, shopworker.getCurrentWorkPlace());
    }


}

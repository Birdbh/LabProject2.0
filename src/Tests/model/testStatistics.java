package model;

import Task.Lists;
import Task.regularTasks;
import observer.statistics;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testStatistics {

    @Test
    public void testdateStatistics(){
        regularTasks task1 = new regularTasks();
        regularTasks task2 = new regularTasks();
        regularTasks task3 = new regularTasks();
        Lists list = new Lists("test");
        list.addObserver(task1);
        list.addObserver(task2);
        list.addObserver(task3);
        statistics stat = new statistics();
        stat.dateStatistics();
        assertEquals(stat.averageObserverNetworkSize, 0);
    }

    @Test
    public void testSizeOfObserverNetwork(){
        statistics stat = new statistics();
        assertTrue(stat.sizeofObserverNetwork() == 0);
    }
}

package model;

import Task.Tasks;
import Task.regularTasks;
import Task.urgentTasks;
import org.junit.Before;
import org.testng.annotations.Test;

import static Task.Tasks.allTasks;
import static Task.regularTasks.regularTasksArrayList;
import static Task.urgentTasks.urgentTasksArrayList;
import static org.junit.Assert.*;

public class testRegularTasks {
    Tasks newtask;

    @Before
    public void setup(){
        newtask = new regularTasks();
    }

    //TODO test whether a task added can be called
    //TODO outcome: test will be called by getter and set by setter
    @Test
    public void testSetterAdGetter(){
        newtask.taskSetter("Test");
        assertEquals(newtask.taskGetter(), "Test");
    }

    //TODO test whether a task can be overwritten
    //TODO outcome: newest task will be shown

    @Test
    public void testOverWriter(){
        newtask = new regularTasks();
        newtask.taskSetter("Test");
        newtask.taskSetter("newTest");
        assertEquals(newtask.taskGetter(), "newTest");
    }

    @Test
    public void testBiDirectional(){
        regularTasks newtask = new regularTasks();
        newtask.addTaskBiDirectonal(newtask);
        assertEquals(regularTasksArrayList.get(0), allTasks.get(0));
    }

    @Test
    public void testEquals(){
        regularTasks newtask = new regularTasks();
        Object o = new Object();
        assertFalse(newtask.equals(o));
    }
}

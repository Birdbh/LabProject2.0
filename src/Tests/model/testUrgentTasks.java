package model;

import Task.Tasks;
import Task.regularTasks;
import Task.urgentTasks;
import org.junit.Before;
import org.testng.annotations.Test;

import static Task.Tasks.allTasks;
import static Task.urgentTasks.urgentTasksArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class testUrgentTasks {
    Tasks newtask;

    @Before
    public void setup(){
        newtask = new urgentTasks();
    }

    //TODO test whether a task added can be called
    //TODO outcome: test will be called by getter and set by setter
    @Test
    public void testSetterAdGetter(){
        Tasks newtask = new urgentTasks();
        newtask.taskSetter("Test");
        assertEquals(newtask.taskGetter(), "Test");
    }

    //TODO test whether a task can be overwritten
    //TODO outcome: newest task will be shown

    @Test
    public void testOverWriter(){
        Tasks newtask = new urgentTasks();
        newtask.taskSetter("Test");
        newtask.taskSetter("newTest");
        assertEquals(newtask.taskGetter(), "newTest");
    }

    @Test
    public void testImportance(){
        Tasks urgentTasks = new urgentTasks();
        assertEquals(urgentTasks.setImportance(8), true);
    }

    @Test
    public void testBiDirectional(){
        urgentTasks newtask = new urgentTasks();
        newtask.addTaskBiDirectonal(newtask);
        assertEquals(urgentTasksArrayList.get(0), allTasks.get(0));
    }

    @Test
    public void testEquals(){
        urgentTasks newtask = new urgentTasks();
        Object o = new Object();
        assertFalse(newtask.equals(o));
    }
}

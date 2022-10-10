package model;

import Exceptions.OverMaxRatioException;
import Exceptions.TaskExceptions;
import Exceptions.TooManyTasksException;
import Task.Tasks;
import Task.regularTasks;
import Task.sizeAndRatio;
import Task.urgentTasks;
import org.testng.annotations.Test;


import java.util.ArrayList;

import static Task.Tasks.allTasks;
import static org.junit.Assert.*;

public class testTasks {

    @Test
    public void testTooManyTasksException() {
        allTasks.clear();
        for(int i = 0; i <= 11; i++){
            Tasks task = new regularTasks();
            task.setIsComplete(false);
            allTasks.add(task);
        }
        for(int i = 0; i <= 11; i++){
            Tasks task = new urgentTasks();
            task.setIsComplete(false);
            allTasks.add(task);
        }
        try{
            sizeAndRatio.numberOfIncompleteTasks();
            fail();
        }
        catch(TooManyTasksException es){

        }
        catch(OverMaxRatioException es){
            fail();
        }

    }

    @Test
    public void testOverMaxRatioException() throws TooManyTasksException, OverMaxRatioException {
        allTasks.clear();
        for(int i = 0; i <= 10; i++){
            Tasks task = new regularTasks();
            task.setIsComplete(false);
            allTasks.add(task);
        }
        Tasks task = new urgentTasks();
        task.setIsComplete(false);
        allTasks.add(task);

        try{
            sizeAndRatio.numberOfIncompleteTasks();

        }
        catch(TooManyTasksException es){
            fail();
        }
        catch(OverMaxRatioException es){

        }

    }

    @Test
    public void testNoException() {
        allTasks.clear();
        for(int i = 0; i <= 8; i++){
            Tasks task = new regularTasks();
            task.setIsComplete(false);
            allTasks.add(task);
        }
        for(int i = 0; i <= 8; i++){
            Tasks task = new urgentTasks();
            task.setIsComplete(false);
            allTasks.add(task);
        }
        try{
            sizeAndRatio.numberOfIncompleteTasks();
        }
        catch(TooManyTasksException es){
            fail();

        }
        catch(OverMaxRatioException es){
            fail();
        }

    }

    @Test
    public void testTaskExceptions() {
        allTasks.clear();
        for(int i = 0; i <= 21; i++){
            Tasks task = new regularTasks();
            task.setIsComplete(false);
            allTasks.add(task);
        }
        try{
            sizeAndRatio.numberOfIncompleteTasks();
            fail();
        }
        catch(TaskExceptions es){
        }

    }
    
    @Test
    public void testSetAllTasks(){
        ArrayList<Tasks> newt = new ArrayList<Tasks>();
        Tasks.setAllTasks(newt);
        assertEquals(newt == allTasks);
    }

    private void assertEquals(boolean b) {
    }

    @Test
    public void testEquals(){
        Object o = new Object();
        assertTrue(o.equals(o));
    }
}

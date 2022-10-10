package model;

import Task.Lists;
import Task.Tasks;
import Task.regularTasks;
import observer.TaskObserver;
import observer.subject;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class testSubject {

    @Test
    public void testAddObserverAndNotify(){
        Lists list = new Lists("test");
        regularTasks task = new regularTasks();
        list.addObserver(task);
        assertEquals(list.observerList.get(0), task);
        LocalDate localDate = LocalDate.now();
        list.notifyObservers(localDate);
        assertEquals(task.getLocalDate(), localDate);
    }
}

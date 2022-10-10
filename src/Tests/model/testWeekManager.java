package model;

import date.Days;
import date.datemanager;
import date.weeks;
import Task.Tasks;
import Task.regularTasks;
import org.junit.Before;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class testWeekManager {
    @Before
    public void before(){
        datemanager datemanager;
    }
    @Test

    //Todo test if the date manager fucntions and takes a date and checks the number
    //Todo outcome: the result is today
    public void testDaysTillDue(){
        datemanager datemanager = new weeks();
        LocalDate localdate = java.time.LocalDate.now();
        AssertJUnit.assertEquals(datemanager.daysTillDue(localdate), 0);
    }

    @Test
    public void testAvgDaysTillDue(){
        datemanager datemanager = new weeks();
        Tasks task1 = new regularTasks();
        task1.setLocalDate();
        Tasks task2 = new regularTasks();
        task2.setLocalDate();
        ArrayList<Tasks> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);
        assertEquals(datemanager.avgDaysTillDue(list), 0);

    }

}

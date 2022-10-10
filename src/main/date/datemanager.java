package date;

import Task.Tasks;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class datemanager {
    public abstract long daysTillDue(LocalDate localdate);
    public abstract int avgDaysTillDue(ArrayList<Tasks> array);

    //Effects: returns the current time
    public LocalDate todaysDate(){
        return java.time.LocalDate.now();
    }
}

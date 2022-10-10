package date;

import Task.Tasks;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Days extends datemanager {

    public HashMap<LocalDate, HashSet<Tasks>> datemaptotask = new HashMap<LocalDate, HashSet<Tasks>>();

    //Requires: A LocalDate Object of anytime
    //Effects: returns the difference between the current LocalDate and the LocalDate passed to it
    @Override
    public long daysTillDue(LocalDate localdate){
        return ChronoUnit.DAYS.between(localdate, LocalDate.now());
    }

    //Requires: A non-empty array of Tasks
    //Modifies: Nothing
    //Effects: returns the average time between each Tasks date and the current date
    public int avgDaysTillDue(ArrayList<Tasks> array){
        int avg = 0;
        for (Tasks tasks : array) {
            avg += daysTillDue(tasks.getLocalDate());
        }
        avg = avg/(array.size());
        return avg;
    }

    //Requires: a task of any type
    //Modifies: Hashmap datemaptotask
    //Effects: adds task to Hashmap with LocalDate as the key
    public void addToMap(Tasks task){
        HashSet<Tasks> tasklist = new HashSet<Tasks>();
        if (datemaptotask.get(task.getLocalDate())==null) {
            datemaptotask.put(task.getLocalDate(),tasklist);
        }
        else{
            tasklist = datemaptotask.get(task.getLocalDate());
        }
        tasklist.add(task);
    }
}

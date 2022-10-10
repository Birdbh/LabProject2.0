package date;

import Task.Tasks;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class weeks extends datemanager {

    //Requires: A LocalDate Object of anytime
    //Effects: returns the difference between the current LocalDate and the LocalDate passed to it in weeks
    @Override
    public long daysTillDue(LocalDate localdate){
        long numberOfDays = ChronoUnit.DAYS.between(localdate, java.time.LocalDate.now());
        long numberOfWeeks = numberOfDays/7;
        return numberOfWeeks;
    }

    //Requires: A non-empty array of Tasks
    //Modifies: Nothing
    //Effects: returns the average time between each Tasks date and the current date in weeks
    @Override
    public int avgDaysTillDue(ArrayList<Tasks> array){
        int avg = 0;
        for (int i = 0; i < array.size(); i++){
            avg += daysTillDue(array.get(i).getLocalDate());
        }
        avg = avg/(array.size());
        return avg;
    }
}

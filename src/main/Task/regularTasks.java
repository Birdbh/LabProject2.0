package Task;

import date.Days;
import observer.TaskObserver;

import java.util.ArrayList;

public class regularTasks extends Tasks {

    public static ArrayList<Tasks> regularTasksArrayList = new ArrayList<>();

    //Requires: an integer value
    //Modifies: the importance value of the object that is passed
    //Effects: returns false if the importance value is greater than or equal to 5
    @Override
    public boolean setImportance(int importance) {
        boolean isSet = false;
        if(importance < 5){
            isSet = true;
            this.importance = importance;
        }
        return isSet;
    }

    //Require: A task that is either a regular or urgent task
    //Modifies: regularTaskArrayList, allTasks, dateMap
    //Effects: If the task is not already added it is added to all three data structures
    @Override
    public void addTaskBiDirectonal(Tasks task){
        if(!regularTasksArrayList.contains(task)){
            regularTasksArrayList.add(task);
            allTasks.add(this);
            Days day = new Days();
            day.addToMap(task);
        }
    }

    public regularTasks() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

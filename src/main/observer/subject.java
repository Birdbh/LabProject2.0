package observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Task.Tasks;

public abstract class subject {
    public List<TaskObserver> observerList = new ArrayList<>();

    //Requires: A task that is a subtype of a TaskObserver is added to a list
    //Modifies: observer of type TaskObserver is added to observerList
    //Effects: observerList has one more element
    public void addObserver(TaskObserver observer){
        if (!observerList.contains(observer)){
            observerList.add(observer);
        }
    }

    //Requires: A date of type LocalDate
    //Effects: Updates the observers in the observerList with the new date
    public void notifyObservers(LocalDate localDate){
        for (TaskObserver observer : observerList){
            observer.update(localDate);
        }
    }
}

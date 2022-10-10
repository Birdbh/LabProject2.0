package Task;

import observer.subject;

import java.util.ArrayList;

public class Lists extends subject {
    String name;
    public ArrayList<Tasks> specialList;


    public Lists(String name){
        this.name = name;
        this.specialList = new ArrayList<>();
    }

    //Requires: A task of type urgent or regular
    //Modifies: Adds a task to specialList, and adds it as an observer
    //Effects: observerList is updated with a new observer for this task
    public void addToList(Tasks task){
        specialList.add(task);
        addObserver(task);
    }

}

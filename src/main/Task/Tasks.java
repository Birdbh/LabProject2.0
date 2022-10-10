package Task;

import observer.TaskObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public abstract class Tasks implements TaskObserver {

    public static ArrayList<Tasks> allTasks = new ArrayList<>();

    private String task;
    public int importance;
    Boolean iscomplete = false;
    private LocalDate LocalDate;

    public Tasks(){
        this.task = task;
        this.importance = importance;
        this.iscomplete = iscomplete;
        this.LocalDate = LocalDate;
    }

    public String taskGetter(){
        return task;
    }

    public void taskSetter(String newtask){
        task = newtask;
    }

    public static void setAllTasks(ArrayList<Tasks> allTasks) {
        Tasks.allTasks = allTasks;
    }

    public int getImportance() {
        return importance;
    }

    public abstract boolean setImportance(int importance);

    public Boolean getIsComplete() {
        return iscomplete;
    }

    public void setIsComplete(Boolean iscomplete) {
        this.iscomplete = iscomplete;
    }

    public java.time.LocalDate getLocalDate() {
        return LocalDate;
    }

    public void setLocalDate() {
        this.LocalDate = java.time.LocalDate.now();
    }
    public void setNewLocalDate(LocalDate localdate){
        this.LocalDate = localdate;
    }

    //Requires: a date of type LocalDate
    //Modifies: changes the task parameter LocalDate
    //Effects: changes the LocalDate
    public void update(LocalDate localDate){
        this.setNewLocalDate(localDate);
    }

    public abstract void addTaskBiDirectonal(Tasks task);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tasks)) return false;
        Tasks tasks = (Tasks) o;
        return Objects.equals(task, tasks.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }
}

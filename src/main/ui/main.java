package ui;

import Exceptions.OverMaxRatioException;
import Exceptions.TooManyTasksException;
import Task.*;
import date.Days;
import date.datemanager;
import maker.maker;
import network.ReadPage;
import write.writer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static Task.Tasks.allTasks;

public class main {

    maker make;


    public static void main(String[] args) throws IOException, TooManyTasksException, OverMaxRatioException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        String path = "C:\\Users\\birdl\\IdeaProjects\\Lab Project\\src\\main\\write\\taskfile.txt";

        new ReadPage();

        writer write = new writer();

        boolean state = true;

        write.load(path);

        maker make = new maker();

        while(state) {

            make.setPrompt("<html>Choose an option: <br/> 1.) Add Task <br/> 2.) Mark Task Complete <br/> 3.) Create SubList <br/> 4.) Save and Quit");

            int input = 0;

            input = Integer.parseInt(make.getInput());

            switch (input) {
                case 1:
                    input = 1;

                    boolean looper = true;

                    make.setPrompt("Is this an 1.) Urgent or 2.) Regular task:");

                    int tasktype = 0;

                    tasktype = Integer.parseInt(make.getInput());

                    Tasks newTask;

                    if (tasktype == 1){
                        newTask = new urgentTasks();
                        newTask.addTaskBiDirectonal(newTask);
                    }
                    else{
                        newTask = new regularTasks();
                        newTask.addTaskBiDirectonal(newTask);
                    }

                    while (looper) {
                        make.setPrompt("How Important is This Task (1-10): ");

                        Integer importance = Integer.valueOf(make.getInput());

                        if (!newTask.setImportance(importance)){
                            make.setPrompt("This is not correct level of important for this task");
                            Thread.sleep(2000);
                        }
                        else{
                            looper = false;
                        }
                    }

                    make.setPrompt("Enter Task Description: ");
                    //System.out.println("Enter Task Description: ");

                    //scan.nextLine();
                    String task = make.getInput();
                    //String task = scan.nextLine();
                    newTask.taskSetter(task);

                    newTask.setLocalDate();

                    maker.playSound();

                    break;

                case 2:
                    input = 2;

                    int completedIndex = 0;

                    make.setPrompt("Which task do you want to make completed: ");

                    completedIndex = Integer.parseInt(make.getInput());

                    allTasks.get(completedIndex - 1).setIsComplete(true);

                    make.setPrompt("Task " + completedIndex + " set to complete");

                    break;

                case 3:
                    input = 3;

                    String listName;
                    int numberOfTasks;

                    make.setPrompt("What is the SubList Name: ");

                    listName = make.getInput();

                    make.setSublistHeader(listName);

                    Lists list = new Lists(listName);

                    make.setPrompt("How many tasks would you like to add this List: ");

                    numberOfTasks = Integer.parseInt(make.getInput());

                    for (int i = 0; i < numberOfTasks; i++){
                        make.setPrompt("Which Task would you like to add: ");
                        list.specialList.add(allTasks.get(Integer.parseInt(make.getInput())));
                    }

                    StringBuilder listOfTasks = new StringBuilder();

                    listOfTasks.append("<html>");

                    for (int i = 0; i < (list.specialList.size()); i++) {
                        if (list.specialList.get(i).getIsComplete()) {
                            listOfTasks.append(i + 1 + ".)" + list.specialList.get(i).taskGetter() + " - Importance: " + list.specialList.get(i).getImportance() + " - Complete -" + " Date Created: " + list.specialList.get(i).getLocalDate());
                            listOfTasks.append("<br/>");
                        } else {
                            listOfTasks.append(i + 1 + ".)" + list.specialList.get(i).taskGetter() + " - Importance: " + list.specialList.get(i).getImportance() + " - Incomplete -" + " Date Created: " + list.specialList.get(i).getLocalDate());
                            listOfTasks.append("<br/>");
                        }
                    }

                    make.setSublist(String.valueOf(listOfTasks));

                    break;

                case 4:
                    input = 4;
                    state = false;
                    break;

                case 5:
                    input = 5;
                    datemanager datemanager = new Days();

                    make.setPrompt(String.valueOf((datemanager.daysTillDue(java.time.LocalDate.now()))));

                case 6:
                    input = 6;
                    datemanager datemanageravg = new Days();

                    make.setPrompt(String.valueOf(datemanageravg.avgDaysTillDue(allTasks)));

                default:
                    make.setPrompt("Non-Excepted Input");
                    break;
            }

        }

        try{
            sizeAndRatio.numberOfIncompleteTasks();
        }
        catch(TooManyTasksException es){
            make.prompt=("There are too many incomplete Tasks");
            System.out.println("There are too many incomplete Tasks");
        }
        catch(OverMaxRatioException es){
            make.prompt=("There are too many incomplete Tasks");
            System.out.println("There needs to be a better ratio between Urgent and Regular Tasks");
        }

        finally {
            write.save(path);
            System.exit(0);
        }

    }

    //Effects: Returns a String that is the total list of all Tasks
    public static String listTasks(){
        
        StringBuilder listOfTasks = new StringBuilder();

        listOfTasks.append("<html>");

        for (int i = 0; i < (allTasks.size()); i++) {
            if (allTasks.get(i).getIsComplete()) {
                listOfTasks.append(i + 1 + ".)" + allTasks.get(i).taskGetter() + " - Importance: " + allTasks.get(i).getImportance() + " - Complete -" + " Date Created: " + allTasks.get(i).getLocalDate());
                listOfTasks.append("<br/>");
            } else {
                listOfTasks.append(i + 1 + ".)" + allTasks.get(i).taskGetter() + " - Importance: " + allTasks.get(i).getImportance() + " - Incomplete -" + " Date Created: " + allTasks.get(i).getLocalDate());
                listOfTasks.append("<br/>");
            }
        }

        listOfTasks.append("</html>");

        return listOfTasks.toString();
    }

}

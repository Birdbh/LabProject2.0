package write;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Task.Tasks;
import Task.regularTasks;
import Task.urgentTasks;

import static Task.Tasks.allTasks;

import static jdk.nashorn.internal.runtime.JSType.toInteger;

public class writer implements Loadable, Saveable {

    //Requires: A String that links to a path
    //Modifies: allTasks
    //Effects: Reads all strings from path file and saves them as tasks in allTasks
    public void load(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);

            Tasks task;

            if(toInteger(partsOfLine.get(1)) > 5){
                task = new urgentTasks();
            }
            else{
                task = new regularTasks();
            }

            task.taskSetter(partsOfLine.get(0));
            task.setImportance(toInteger(partsOfLine.get(1)));
            Boolean importance = Boolean.valueOf(partsOfLine.get(2));
            task.setIsComplete(importance);
            task.setNewLocalDate(LocalDate.parse(partsOfLine.get(3)));
            allTasks.add(task);
        }
    }


    //Requires: A String
    //Effects: Return the string split on spaces
    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    //Requires: A String for a file path
    //Modifies: the write path file
    //Effects: writes allTask to the path file
    public void save(String path) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(path);
        for (Tasks task : allTasks) {
            writer.println(task.taskGetter() + " " + task.getImportance() + " " + task.getIsComplete() + " " + task.getLocalDate());
        }
        writer.close();
    }

}

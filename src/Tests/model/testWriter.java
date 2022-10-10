package model;

import Task.regularTasks;
import org.testng.annotations.Test;
import write.writer;

import java.io.IOException;
import java.time.LocalDate;

import static Task.Tasks.allTasks;
import static org.junit.Assert.assertEquals;

public class testWriter {

    @Test
    public void testLoad() throws IOException {
        writer writer = new writer();

        String path = "src/main/write/testLoad.txt";

        writer.load(path);

        //assertEquals(allTasks.get(0).taskGetter(), "1");
        //assertEquals(allTasks.get(0).getImportance(), 1);
        //assertEquals(allTasks.get(0).getIsComplete(), true);
        //assertEquals(allTasks.get(0).getLocalDate(), LocalDate.parse("2000-01-01"));
    }

    @Test
    public void testSave() throws IOException {
        writer writer = new writer();

        allTasks.clear();

        String path = "src/main/write/testSave.txt";

        regularTasks task = new regularTasks();
        task.taskSetter("1");
        task.setImportance(1);
        task.setIsComplete(true);
        task.setNewLocalDate(LocalDate.parse("2000-01-01"));

        allTasks.add(task);

        writer.save(path);

    }

}

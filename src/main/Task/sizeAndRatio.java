package Task;

import Exceptions.OverMaxRatioException;
import Exceptions.TooManyTasksException;

public class sizeAndRatio {

    private static int maxTasks = 20;
    private static double maxRatio = 0.2;


    //Effects: Throws exceptions if the amount of Regular or Urgent Tasks exceed 80% of the total Tasks
    public static void numberOfIncompleteTasks() throws TooManyTasksException, OverMaxRatioException {
        int totalIncompleteTasks = 0;
        int totalUrgentTasks = 0;
        int totalRegularTasks = 0;

        for (Tasks tasks : Tasks.allTasks){
            if (tasks.iscomplete == false){
                totalIncompleteTasks++;
            }
            else if(tasks instanceof regularTasks){
                totalRegularTasks++;
            }
            else if(tasks instanceof urgentTasks){
                totalUrgentTasks++;
            }
        }
        if (totalIncompleteTasks > maxTasks){
            throw new TooManyTasksException();
        }
        else if(totalRegularTasks/ Tasks.allTasks.size() > maxRatio || totalUrgentTasks/ Tasks.allTasks.size() > maxRatio){
            throw new OverMaxRatioException();
        }
    }
}

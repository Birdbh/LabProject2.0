package observer;

import java.time.LocalDate;
import java.util.ArrayList;

public class statistics extends subject {
    ArrayList<Integer> sizeOfObserverNetworks = new ArrayList<Integer>();
    public int averageObserverNetworkSize;

    //Modifies: updates the average size of all the observerLists
    public void dateStatistics(){
        sizeOfObserverNetworks.add(observerList.size());

        int sum = 0;

        for(Integer integer : sizeOfObserverNetworks){
            sum+=integer;
        }
        averageObserverNetworkSize=(sum/sizeOfObserverNetworks.size());
    }

    //Effect: Returns the average Observer Network Size
    public int sizeofObserverNetwork(){
        return averageObserverNetworkSize;
    }
}

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



class Resulttt
{
    
    /*
     * Complete the 'arrangeMeetings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY meetings
     */
    
    public static int arrangeMeetings(int k, List<List<Integer>> meetings)
    {
        /**
         * 3 k
         * 4 meeting
         * 2
         * 1 100
         * 2 50
         * 5 100
         * 1 60
         * */
        int totalPriority=0;
        List<Meeting> durPriority = new ArrayList<>();
        for (int i = 0; i < meetings.size(); i++)
        {
            Integer duration = meetings.get(i).get(0);
            Integer priority = meetings.get(i).get(1);
            if(duration<=k) // remove meetings greater than time allowed
            {
                durPriority.add(new Meeting(duration, priority));
            }
        }
        durPriority.sort(Comparator.comparing(Meeting::getPriority, Comparator.reverseOrder())); // sort priority in descending order
        int allowedMeetings=0;
        for (Meeting m: durPriority)
        {
            allowedMeetings += m.duration;
            if (allowedMeetings <=k) // check allowed meetings
            {
                totalPriority += m.priority;
            }
            else
            {
                break;
            }
        }
        
        return totalPriority;
    }
    
}

public class ArrangeMeetings
{
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(bufferedReader.readLine().trim());
        
        int meetingsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int meetingsColumns = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<List<Integer>> meetings = new ArrayList<>();
        
        IntStream.range(0, meetingsRows).forEach(i ->
                                                 {
                                                     try
                                                     {
                                                         meetings.add(
                                                                 Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                                                       .map(Integer::parseInt)
                                                                       .collect(Collectors.toList())
                                                         );
                                                     }
                                                     catch (IOException ex)
                                                     {
                                                         throw new RuntimeException(ex);
                                                     }
                                                 });
        
        int result = Resulttt.arrangeMeetings(k, meetings);
        System.out.println(result);
    
        bufferedReader.close();
    }
}

class Meeting
{
    public Meeting(int duration, int priority)
    {
        this.duration = duration;
        this.priority = priority;
    }
    
    int duration;
    int priority;
    
    public int getDuration()
    {
        return duration;
    }
    
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    
    public int getPriority()
    {
        return priority;
    }
    
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
}
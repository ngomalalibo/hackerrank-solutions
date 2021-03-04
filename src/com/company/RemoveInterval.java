package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInterval
{
    public static void removeInterval(int[][] interval, int[] tobeRemoved)
    {
        List<Integer>[] sortedIntervals = new List[interval.length * 2];
        
        for (int i = 0, k = 0; i < interval.length; i++)
        {
            int start = interval[i][0];
            int end = interval[i][1];
            
            if (start <= tobeRemoved[0] && end > tobeRemoved[0])
            {
                sortedIntervals[k] = new ArrayList<>();
                sortedIntervals[k].add(start);
                sortedIntervals[k++].add(tobeRemoved[0]);
            }
            if (start < tobeRemoved[1] && end > tobeRemoved[1])
            {
                sortedIntervals[k] = new ArrayList<>();
                sortedIntervals[k].add(tobeRemoved[1]);
                sortedIntervals[k++].add(end);
            }
        }
        
        for (int i = 0; i < sortedIntervals.length; i++)
        {
            if (sortedIntervals[i] != null)
            {
                System.out.println(Arrays.toString(sortedIntervals[i].toArray()));
            }
        }
    }
    
    public static void main(String[] args)
    {
        // int[][] intervals = new int[][]{{0, 2}, {3, 4}, {5, 7}};
        // int[] toBeRemoved = new int[]{1, 6};
        
        int[][] intervals = new int[][]{{0, 5}};
        int[] toBeRemoved = new int[]{2, 3};
        
        removeInterval(intervals, toBeRemoved);
    }
    
    /* Option 2. Works
    public static void removeInterval(int[][] interval, int[] tobeRemoved)
    {
        int[][] sortedIntervals = new int[interval.length*2][interval[0].length];
        
        for (int i = 0; i < sortedIntervals.length; i++)
        {
            Arrays.fill(sortedIntervals[i], 0);
        }
        for (int i = 0, k = 0; i < interval.length; i++)
        {
            int start = interval[i][0];
            int end = interval[i][1];
            
            if (start <= tobeRemoved[0] && end > tobeRemoved[0])
            {
                sortedIntervals[k][0] = start;
                sortedIntervals[k++][1] = tobeRemoved[0];
            }
            if (start < tobeRemoved[1] && end > tobeRemoved[1])
            {
                sortedIntervals[k][0] = tobeRemoved[1];
                sortedIntervals[k++][1] = end;
            }
        }
        
        for (int i = 0; i < sortedIntervals.length; i++)
        {
            if(sortedIntervals[i][0] != 0 || sortedIntervals[i][1]!=0)
            {
                System.out.println(Arrays.toString(sortedIntervals[i]));
            }
        }
    }*/
}
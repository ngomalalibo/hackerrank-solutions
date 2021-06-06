package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals
{
    // solved
    public int[][] merge(int[][] intervals)
    {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int leng = intervals.length;
        int prevEnd = 0;
        int prevStart = 0;
        /** {1, 3}, {2, 6}, {8, 10}, {15, 18}  */
        for (int i = 0; i < leng; i++)
        {
            if (i == 0)
            {
                prevEnd = intervals[i][1];
                prevStart = intervals[i][0];
            }
            else if (intervals[i][0] <= prevEnd)
            {
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            }
            else if (intervals[i][0] > prevEnd)
            {
                merged.add(new int[]{prevStart, prevEnd});
                prevEnd = intervals[i][1];
                prevStart = intervals[i][0];
            }
        }
        merged.add(new int[]{prevStart, prevEnd});
        
        return merged.toArray(new int[merged.size()][]);
    }
    
    /*
    //copied
    public int[][] merge(int[][] intervals)
    {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] <= prevEnd)
            {
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            }
            else
            {
                list.add(new int[]{prevStart, prevEnd});
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            }
        }
        list.add(new int[]{prevStart, prevEnd});
        return list.toArray(new int[list.size()][]);
    }
    * */
    
    public static void main(String[] args)
    {
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 4}, {0, 4},})));
    }
}

package com.company.leetcode;

import java.util.Arrays;

/**
 * Given an array of intervals return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals
{
    public int eraseOverlapIntervals(int[][] intervals)
    {
        
        int leng = intervals.length;
        if (intervals == null || leng == 0)
        {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) ->
        {
            int i = a[0] - b[0];
            if (i == 0)
            {
                return a[1] - b[1];
            }
            return i;
        });
        
        // Counting how many Non-overlapping Intervals we can get at most
        int count = 0, preEnd = intervals[0][1];
        
        for (int i = 1; i < leng; i++)
        {
            
            int curStart = intervals[i][0], curEnd = intervals[i][1];
            // No conflict between cur and pre interval
            if (preEnd <= curStart)
            {
                count++;
                preEnd = curEnd;
            }
            else
            { // Has conflict
                // We remove the interval whose end index is larger
                // in other words, we keep the one whose end index is smaller
                preEnd = Math.min(preEnd, curEnd);
            }
        }
        ++count;
        return leng - count;
    }
    
    // how many pairs remain after the original array
    public static void main(String[] args)
    {
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{1, 2}, {1, 3}, {2, 3}, {3, 4}}));
    }
}

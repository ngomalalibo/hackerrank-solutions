package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// copied and reworked
public class InsertInterval
{
    public int[][] convert(List<int[]> merged)
    {
        int[][] primArray = new int[merged.size()][];
        int i = 0;
        for (int[] pair : merged)
        {
            primArray[i++] = pair;
        }
        
        return primArray;
    }
    
    public int[][] insert(int[][] intvl, int[] newInterval)
    {
        int leng = intvl.length;
        List<int[]> merged = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        
        for (; i < leng; i++)
        {
            if (intvl[i][1] < newStart)
            {
                merged.add(intvl[i]);
                continue;
            }
            break;
        }
        
        while (i < leng && newEnd >= intvl[i][0])
        {
            newStart = Math.min(intvl[i][0], newStart);
            newEnd = Math.max(intvl[i][1], newEnd);
            i++;
        }
        
        merged.add(new int[]{newStart, newEnd});
        
        while (i < leng)
        {
            merged.add(intvl[i]);
            i++;
        }
        return convert(merged);
    }
    
    public static void main(String[] args)
    {
        System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{{2, 3}, {6, 9}}, new int[]{0, 1})));
        System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{}, new int[]{5, 7})));
        System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{{1, 5}}, new int[]{2, 7})));
        System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{{1, 5}}, new int[]{6, 8})));
    }
}

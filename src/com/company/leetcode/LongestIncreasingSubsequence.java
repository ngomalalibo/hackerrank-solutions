package com.company.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// longest subsequence. longest array sublist
public class LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums)
    {
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            int index = Collections.binarySearch(lis, nums[i]);
            index = (index < 0) ? -index - 1 : index;  // making index positive if it is not present
            if (index == lis.size())
            {
                lis.add(nums[i]);
            }
            else
            {
                lis.set(index, nums[i]);
            }
        }
        return lis.size();
    }
    
    public static void main(String[] args)
    {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{2, 15, 3, 7, 8, 6, 18}));
        
    }
}

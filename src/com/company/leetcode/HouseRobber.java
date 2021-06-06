package com.company.leetcode;

public class HouseRobber
{
    // copied solution. non-adjacent max. dynamic programming
    public int rob(int[] nums)
    {
        int with = nums[0];
        int without = 0;
        
        for (int i = 1; i < nums.length; i++)
        {
            int previousWithout = without;
            without = Math.max(without, with);
            with = previousWithout + nums[i];
            
        }
        return Math.max(with, without);
    }
    
    public static void main(String[] args)
    {
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
    }
}

package com.company.leetcode;

public class CombinationSumIV
{
    public int combinationSum4(int[] nums, int target)
    {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int tar = 1; tar < target + 1; tar++)
        {
            for (int i = 0; i < nums.length; i++)
            {
                System.out.println("numi " + nums[i]);
                if (nums[i] <= tar)
                {
                    dp[tar] += dp[tar - nums[i]];
                    System.out.println("dptar: " + dp[tar]);
                }
            }
        }
        return dp[target];
    }
    
    public static void main(String[] args)
    {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}

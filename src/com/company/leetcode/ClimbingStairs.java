package com.company.leetcode;

public class ClimbingStairs
{
    // Formula for no of ways
    public int climbStairs(int n)
    {
        
        int arr[] = new int[n + 1];
        //We take arr[0] for sake of simplicity even we shouldn't be bothered as it
        // is not part of constraint
        arr[0] = 1;
        arr[1] = 1;
        
        for (int i = 2; i <= n; ++i)
        {
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.println(arr[i]);
        }
        
        return arr[n];
    }
    
    
    public static void main(String[] args)
    {
        new ClimbingStairs().climbStairs(5);
    }
}

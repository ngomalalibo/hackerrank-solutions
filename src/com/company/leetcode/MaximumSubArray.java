package com.company.leetcode;

public class MaximumSubArray
{
    //practive working
    public static int maxSubArray(int[] arr)
    {
        int maxSum = arr[0];
        int sum = maxSum;
        int leng = arr.length;
        for (int i = 1; i < leng; i++)
        {
            sum = Math.max(sum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
    
    /*public static int maxSubArray(int[] arr)
    {
        int leng = arr.length;
        int maxSum = arr[0];
        
        for (int i = 0; i < leng; i++)
        {
            int sum = 0;
            for (int j = i; j < leng; j++)
            {
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum;
    }*/
    
    /*public static int maxSubArray(int[] arr)
    {
        int max = arr[0];
        int maxSum = arr[0];
        int leng = arr.length;
        for (int i = 0; i < leng; i++)
        {
            int sum = 0;
            if (max < arr[i])
            {
                max = arr[i];
            }
            for (int j = i; j < leng; j++)
            {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
            
            maxSum = Math.max(maxSum, max);
        }
        return maxSum;
    }*/
    
    public static void main(String[] args)
    {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}

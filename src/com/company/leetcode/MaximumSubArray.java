package com.company.leetcode;

public class MaximumSubArray
{
    public static int maxSubArray(int[] arr)
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
    }
    
    public static void main(String[] args)
    {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}

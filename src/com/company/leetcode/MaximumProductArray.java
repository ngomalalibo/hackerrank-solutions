package com.company.leetcode;

public class MaximumProductArray
{
    public static int maxProduct(int[] arr)
    {
        int maxProd = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++)
        {
            int product = 1;
            for (int j = i; j < arr.length; j++)
            {
                product *= arr[j];
                maxProd = Math.max(maxProd, product);
            }
        }
        return maxProd;
    }
    
    public static void main(String[] args)
    {
        // int[] arr = new int[]{2, 3, -2, 4};
        int[] arr = new int[]{-2};
        System.out.println(maxProduct(arr));
    }
}

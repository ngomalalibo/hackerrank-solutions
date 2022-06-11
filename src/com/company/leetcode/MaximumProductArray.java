package com.company.leetcode;

public class MaximumProductArray
{
    public static int maxProduct(int[] A)
    {
        int n = A.length;
        if (n == 1)
        {
            return A[0];
        }
        
        int max, prod, negProd, currProd;
        max = negProd = prod = A[0];
        
        for (int i = 1; i < n; i++)
        {
            currProd = prod * A[i];
            prod = Math.max(A[i], Math.max(currProd, negProd * A[i]));
            negProd = Math.min(A[i], Math.min(currProd, negProd * A[i]));   //for next iteration
            
            if (prod > max)
            {
                max = prod;
            }
        }
        return max;
    }
    /*public static int maxProduct(int[] arr)
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
    }*/
    
    public static void main(String[] args)
    {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2}));
        System.out.println(maxProduct(new int[]{0, 2}));
        System.out.println(maxProduct(new int[]{3, -1, 4}));
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
    }
}

package com.company.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf
{
    // practice work. time exceeds
    /*public static int[] productExceptSelf(int[] arr)
    {
        int leng = arr.length;
        int[] answer = new int[leng];
        int product = 1;
        
        for (int i = 0; i < leng; i++)
        {
            int j = 0;
            while (j < leng)
            {
                if (j != i)
                {
                    product *= arr[j];
                }
                j++;
            }
            
            answer[i] = product;
            product = 1;
        }
        return answer;
    }*/
    
    public static int[] productExceptSelf(int[] nums)
    {
        // 1, 2, 3, 4
        int leng = nums.length;
        int[] output = new int[leng];
        int[] L = new int[leng];
        int[] R = new int[leng];
        L[0] = 1;
        for (int i = 1; i < leng; i++)
        {
            L[i] = L[i - 1] * nums[i - 1];
            
        }
        R[leng - 1] = 1;
        for (int i = leng - 2; i >= 0; i--)
        {
            R[i] = R[i + 1] * nums[i + 1];
        }
        
        for (int i=0; i<leng;i++)
        {
            output[i] = L[i]*R[i];
        }
        return output;
    }
    
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4};
        
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}

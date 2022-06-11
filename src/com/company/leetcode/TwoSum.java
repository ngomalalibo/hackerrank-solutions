package com.company.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum
{
    // practice solved
    public static int[] twoSum(int[] arr, int target)
    {
        int[] sum = new int[2];
        int leng = arr.length;
        boolean found = false;
        for (int i = 0; i < leng; i++)
        {
            for (int j = i + 1; j < leng; j++)
            {
                if (found)
                {
                    break;
                }
                if (arr[i] + arr[j] == target)
                {
                    sum[0] = i;
                    sum[1] = j;
                    found = true;
                    break;
                }
            }
            
        }
        
        return sum;
    }
    /*public static int[] twoSum(int[] nums, int target)
    {
        //Input: nums = [2,7,11,15], target = 9
        int[] sum = new int[2];
        boolean pass = false;
        for (int i = 0; i < nums.length; i++)
        {
            if (pass)
            {
                break;
            }
            for (int j = 0; j < nums.length; j++)
            {
                if(i!=j)
                {
                    int test = nums[i] + nums[j];
                    if (test == target)
                    {
                        sum[0] = i;
                        sum[1] = j;
                        pass = true;
                        break;
                    }
                }
            }
        }
        return sum;
    }*/
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int target = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[arrItems.length];
        for (int i = 0; i < arrItems.length; i++)
        {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        int[] res = twoSum(arr, target);
        
        System.out.println(Arrays.toString(res));
        
        scanner.close();
    }
}

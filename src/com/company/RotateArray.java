package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RotateArray
{
    public static int[] rotate(int[] nums, int k)
    {
        /** 1 2 3 4 5 6 7   3*/
        /** 5 6 7 1 2 3 4 */
        int l = nums.length;
        int index = Math.abs(l - k);
        int[] result = new int[l];
        for (int j = 0; j < l; j++)
        {
            if (index == l)
            {
                index = 0;
            }
            if (index < l)
            {
                result[j] = nums[index];
            }
            index++;
        }
        
        return result;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner("1 2 3 4 5 6 7");
        String[] components = sc.nextLine().split(" ");
        
        int[] nums = new int[components.length];
        
        for (int i = 0; i < components.length; i++)
        {
            nums[i] = Integer.parseInt(components[i]);
        }
        
        // int k = Integer.parseInt(sc.nextLine());
        int k =0;
        
        int[] result = rotate(nums, k);
        System.out.println(Arrays.toString(result));
    }
}

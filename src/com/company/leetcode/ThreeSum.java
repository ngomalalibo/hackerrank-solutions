package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum
{
    public List<List<Integer>> threeSum(int[] arr)
    {
        List<List<Integer>> result = new ArrayList<>();
        int l = arr.length;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < l; i++)
        {
            if (i > 0 && arr[i] == arr[i - 1])
            {
                continue;
            }
            int j = i + 1;
            int k = l - 1;
            while (j < k)
            {
                int sum = arr[j] + arr[k] + arr[i];
                if (sum == 0)
                {
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) //prevent duplicates
                    {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1])
                    {
                        k--;
                    }
                }
                else if (sum > 0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        
        return result;
    }


    
    public static void main(String[] args)
    {
        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        // int[] arr = new int[]{1, 0, -1};
        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        // int[] arr = new int[]{1, -1};
        // int[] arr = new int[]{0, 0, 0};
        // int[] arr = new int[]{1, 2, -2, -1};
        int[] arr = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        List<List<Integer>> threeSum = new ThreeSum().threeSum(arr);
        for (List<Integer> ints : threeSum)
        {
            System.out.println(ints.toString());
        }
    }
}



package com.company.leetcode;

import java.util.Arrays;

public class ContainsDuplicate
{
    // practice works
    public static boolean containsDuplicate(int[] arr)
    {
        Arrays.sort(arr);
        int leng = arr.length;
        for (int i = 0; i < leng - 1; i++)
        {
            if (arr[i] == arr[i + 1])
            {
                return true;
            }
        }
        return false;
    }
    // practice works
    /*public static boolean containsDuplicate(int[] arr)
    {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        return set.size() != list.size() ;
    }*/
    
    /**
     * 1,2,3,1
     */
    /*public static boolean containsDuplicate(int[] arr)
    {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] == arr[i + 1])
            {
                return true;
            }
        }
        return false;
    }*/
    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate(arr));
    }
    
    
}

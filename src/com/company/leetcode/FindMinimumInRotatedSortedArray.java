package com.company.leetcode;

public class FindMinimumInRotatedSortedArray
{
    public int findMin(int[] arr)
    {
        int min = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[min] > arr[i])
            {
                min = i;
            }
        }
        return arr[min];
    }
    
    public void swap(int[] array, int a, int b)
    {
        if (a == b)
        {
            return;
        }
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    public static void main(String[] args)
    {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(arr));
    }
}

package com.company;

import java.util.Arrays;

public class QuickSort
{
    // unstable sort.
    public static void quickSort(int[] array, int start, int end)
    {
        if ((end - start) < 2)
        {
            return;
        }
        
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }
    
    private static int partition(int[] array, int start, int end)
    {
        // this is using the first element as the pivot
        int pivot = array[start];
        int i = start;
        int j = end;
        
        while (i < j)
        {
            // NOTE: empty loop
            while (i < j && array[--j] >= pivot)
            {
            }
            if (i < j)
            {
                array[i] = array[j];
            }
            
            // NOTE: empty loop
            while (i < j && array[++i] <= pivot)
            {
            }
            if (i < j)
            {
                array[j] = array[i];
            }
        }
        array[j] = pivot;
        return j;
    }
    
    public static void main(String[] args)
    {
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        //quickSort(array, 0, array.length);
        Arrays.parallelSort(array);
        System.out.println(Arrays.toString(array));
    }
}

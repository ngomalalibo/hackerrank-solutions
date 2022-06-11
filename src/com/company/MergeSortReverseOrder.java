package com.company;

import java.util.Arrays;

public class MergeSortReverseOrder
{
    // recursive merge sort. stable sort
    public static void mergeSort(int[] array, int start, int end)
    {
        if (end - start < 2)
        {
            return;
        }
        
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
        
    }
    
    private static void merge(int[] array, int start, int mid, int end)
    {
        // reverse change 1
        if (array[mid - 1] >= array[mid])
        {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;
        
        int[] temp = new int[end - start];
        while (i < mid && j < end)
        {
            // reverse change 2
            temp[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++];
        }
        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);
        
    }
    
    public static void main(String[] args)
    {
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        mergeSort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
}

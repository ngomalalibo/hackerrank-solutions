package com.company;

import java.util.Arrays;

public class InsertionSortRecursion
{
    public static void recursiveInsertionSort(int[] array, int numItems)
    {
        
        // breaking condition
        if (numItems < 2)
        {
            return;
        }
        recursiveInsertionSort(array, numItems - 1);
        int leng = array.length;
    
        int newElement = array[numItems-1];
        int k = numItems-1;
        while (k > 0 && array[k - 1] > newElement)
        {
            array[k] = array[k - 1];
            k--;
        }
        array[k] = newElement;
    }
    
    //insertion sort. stable sort
    public static void main(String[] args)
    {
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        
        recursiveInsertionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}

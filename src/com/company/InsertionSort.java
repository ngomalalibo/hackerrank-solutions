package com.company;

import java.util.Arrays;

public class InsertionSort
{
    //insertion sort. stable sort
    public static void insertionSort(int[] array)
    {
        int leng = array.length;
        int newElement = 0;
        for (int i = 1; i < leng; i++)
        {
            newElement = array[i];
            int k = i;
            while (k > 0 && array[k - 1] > newElement)
            {
                array[k] = array[k - 1];
                k--;
            }
            array[k] = newElement;
        }
    }
    
    public static void main(String[] args)
    {
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}

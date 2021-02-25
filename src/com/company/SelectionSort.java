package com.company;

import java.util.Arrays;

public class SelectionSort
{
    //selection sort/ unstable sort
    public static void main(String[] args)
    {
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        int largest = -1;
        for (int leng = array.length; leng > 0; leng--)
        {
            largest = 0;
            for (int i = 1; i < leng; i++)
            {
                if (array[i] > array[largest])
                {
                    largest = i;
                }
            }
            swap(array, leng - 1, largest);
        }
        System.out.println(Arrays.toString(array));
    }
    
    public static void swap(int[] array, int a, int b)
    {
        if (a == b)
        {
            return;
        }
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

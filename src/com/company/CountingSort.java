package com.company;

import java.util.Arrays;

public class CountingSort
{
    public static void countingSort(int[] array, int min, int max)
    {
        int[] countingArray = new int[(max - min) + 1];
        for (int i = 0; i < array.length; i++)
        {
            countingArray[array[i] - min]++;
        }
        
        for (int i = min, j=0; i <= max; i++)
        {
            while (countingArray[i - min] > 0)
            {
                array[j++] = i;
                countingArray[i - min]--;
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[] array = new int[]{2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        
        
        countingSort(array, 1, 10);
        System.out.println(Arrays.toString(array));
    }
}

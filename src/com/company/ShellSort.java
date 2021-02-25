package com.company;

import java.util.Arrays;

public class ShellSort
{
    //shell sort. variation of insertion sort. an unstable sort
    public static void main(String[] args)
    {
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        int leng = array.length;
        int newElement;
        for (int gap = leng / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < leng; i++)
            {
                newElement = array[i];
                int k = i;
                while (k >= gap && array[k - gap] > newElement)
                {
                    array[k] = array[k - gap];
                    k -= gap;
                }
                array[k] = newElement;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

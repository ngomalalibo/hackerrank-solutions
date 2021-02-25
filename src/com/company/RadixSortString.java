package com.company;

import java.util.Arrays;

public class RadixSortString
{
    public static void radixSort(String[] array, int radix, int width)
    {
        for (int i = width - 1; i >= 0; i--)
        {
            radixSingleSort(array, i, radix);
        }
    }
    
    private static void radixSingleSort(String[] array, int position, int radix)
    {
        int numItems = array.length;
        int[] countArray = new int[radix];
        
        for (String value : array)
        {
            countArray[getCharIndex(position, value)]++;
        }
        
        //adjust the count array
        for (int j = 1; j < radix; j++)
        {
            countArray[j] += countArray[j - 1];
        }
        
        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
        {
            temp[--countArray[getCharIndex(position, array[tempIndex])]] = array[tempIndex];
        }
        
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++)
        {
            array[tempIndex] = temp[tempIndex];
        }
    }
    
    private static int getCharIndex(int position, String value)
    {
        return value.charAt(position) - 'a';
    }
    
    public static void main(String[] args)
    {
        String[] array = new String[]{"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        radixSort(array, 26, 5);
        System.out.println(Arrays.toString(array));
    }
    
}

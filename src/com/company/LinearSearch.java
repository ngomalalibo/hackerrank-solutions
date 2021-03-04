package com.company;

public class LinearSearch
{
    public static int linearSearch(int[] array, int value)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == value)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] array = new int[]{20, 53, -15, 7, 55, 1, -22};
        System.out.println(linearSearch(array, 55));
    }
}

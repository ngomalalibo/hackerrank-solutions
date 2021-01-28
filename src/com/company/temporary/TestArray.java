package com.company.temporary;

public class TestArray
{
    private static int sum;
    
    public static void printArray(int[] array)
    {
        for (int i=0; i<array.length;i++)
        {
            sum+=array[i];
        }
        System.out.println("Sum: "+sum);
    }
    public static void main(String[] args)
    {
    
    }
}

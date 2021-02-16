package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SortingBubbleSort
{
    // Complete the countSwaps function below.
    static void countSwaps(int[] a)
    {
        int n = a.length;
        int numSwaps = 0;
        int last = a[numSwaps];
        
        boolean sorted = false;
        for (; n > 1 && !sorted; )
        {
            int count = 0;
            for (int j = 0; j < n - 1 && !sorted; j++)
            {
                if (a[j] > a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    count++;
                    numSwaps++;
                    sorted = false;
                }
                else if (j == n - 2 && count == 0)
                {
                    sorted = true;
                }
                if (j == n - 2 && n == a.length)
                {
                    last = a[a.length - 1];
                }
            }
            n--;
        }
        //System.out.println(Arrays.toString(a));
        int first = a[0];
        System.out.println("Array is sorted in " + numSwaps + " swaps.");
        System.out.println("First Element: " + first);
        System.out.println("Last Element: " + last);
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] a = new int[n];
        
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++)
        {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        
        countSwaps(a);
        
        scanner.close();
    }
}
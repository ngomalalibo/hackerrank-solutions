package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifferenceInAnArray
{
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr)
    {
        int minAbsDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int leng = arr.length;
        int minDiff = 0;
        for (int i = 0; i < leng - 1; i++)
        {
            minDiff = Math.abs(arr[i] - arr[i + 1]);
            if (minDiff < minAbsDiff)
            {
                minAbsDiff = minDiff;
            }
        }
        
        return minAbsDiff;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[n];
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++)
        {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        int result = minimumAbsoluteDifference(arr);
        
        System.out.println(result);
        scanner.close();
    }
}

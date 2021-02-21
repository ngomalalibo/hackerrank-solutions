package com.company;

import java.io.IOException;
import java.util.Scanner;

public class MergeSortCountingInversions
{
    
    private static long countInversions(int[] arr)
    {
        int[] aux = arr.clone();
        return countInversions(arr, 0, arr.length - 1, aux);
    }
    
    private static long countInversions(int[] arr, int lo, int hi, int[] aux)
    {
        if (lo >= hi)
        {
            return 0;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        long count = 0;
        count += countInversions(aux, lo, mid, arr);
        count += countInversions(aux, mid + 1, hi, arr);
        count += merge(arr, lo, mid, hi, aux);
        
        return count;
    }
    
    private static long merge(int[] arr, int lo, int mid, int hi, int[] aux)
    {
        long count = 0;
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi)
        {
            if (i > mid)
            {
                arr[k++] = aux[j++];
            }
            else if (j > hi)
            {
                arr[k++] = aux[i++];
            }
            else if (aux[i] <= aux[j])
            {
                arr[k++] = aux[i++];
            }
            else
            {
                arr[k++] = aux[j++];
                count += mid + 1 - i;
            }
        }
        
        return count;
    }
    
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++)
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
            
            long result = countInversions(arr);
            System.out.println(result);
        }
        
        scanner.close();
    }
}

/* Work as bubble sort for does not pass all test cases
* static long countInversions(int[] arr)
    {
        int noOfSwaps = 0;
        int leng = arr.length;
        boolean sorted = false;
        int temp = 0;
        int counter;
        while (!sorted)
        {
            counter = 0;
            for (int i = 0; i < leng - 1; ++i)
            {
                if (arr[i] > arr[i + 1])
                {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    ++noOfSwaps;
                    ++counter;
                }
                if (i == leng - 2 && counter == 0)
                {
                    sorted = true;
                }
            }
        }
        
        return noOfSwaps;
    }
    * */
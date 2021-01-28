package com.company.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution
{
    
    
    // private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner = new Scanner("10, 20, 20, 10, 10, 30, 50, 10, 20");
    // private static final Scanner scanner = new Scanner("1, 2, 1, 2, 1, 3, 2");
    
    public static void main(String[] args) throws IOException
    {
        // {10 20 20 10 10 30 50 10 20}. n=9
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));*/
        
        
        // int n = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        
        String[] arItems = scanner.nextLine().split(", ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int n = arItems.length;
        int[] ar = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        
        int result = sockMerchant(n, ar);
        System.out.println("result -> " + result);
        
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();*/
        
        scanner.close();
    }
    
    // {10 20 20 10 10 30 50 10 20}. n=9. result = 3
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar)
    {
        // hold no of pairs
        int noOfPairs = 0;
        // hold no of socks
        int sameSockCounter = 0;
        //holds already checked colors
        Set<Integer> checkedItems = new HashSet<>();
        // iterate all socks
        for (int i = 0; i < n && i <= 100; i++)
        {
            //checks if color value is below 100
            if (ar[i] >= 1 && ar[i] <= 100)
            {
                //check current sock against all others
                for (int j = 0; j < n; j++)
                {
                    //check if socks has already been checked
                    if (ar[i] == ar[j] && !checkedItems.contains(ar[i]))
                    {
                        ++sameSockCounter;
                    }
                    
                }
            }
            //convert no of sock to even pairs and aggregate
            noOfPairs += (sameSockCounter / 2);
            //add checked item to set to prevent checking color again
            checkedItems.add(ar[i]);
            //reset even counter
            sameSockCounter = 0;
            
            
        }
        
        return noOfPairs;
        
    }
}

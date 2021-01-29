package com.company.interviewprep;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SalesByMatch2
{
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar)
    {
        int totalPairs = 0;
        int noOfPairs;
        int matching = 0;
        Set<Integer> colors = new HashSet<>();
        Set<Integer> checkItems = new HashSet<>();
        for (int a : ar)
        {
            colors.add(a);
        }
        
        for (int i = 0; i < ar.length; i++)
        {
            matching = 0;
            if (!checkItems.contains(ar[i]))
            {
                for (int j = 0; j < ar.length; j++)
                {
                    if (ar[j] == ar[i])
                    {
                        matching++;
                    }
                }
                if (matching % 2 == 0)
                {
                    noOfPairs = matching / 2;
                }
                else
                {
                    --matching;
                    noOfPairs = matching / 2;
                }
                totalPairs += noOfPairs;
                
                checkItems.add(ar[i]);
            }
            
        }
        
        return totalPairs;
    }
    
    // private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner = new Scanner("10, 20, 20, 10, 10, 30, 50, 10, 20");
    
    public static void main(String[] args) throws IOException
    {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String[] arItems = scanner.nextLine().split(", ");
        
        int n = arItems.length;
        int[] ar = new int[n];
        
        
        for (int i = 0; i < n; i++)
        {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        
        int result = sockMerchant(n, ar);
        
        System.out.println("result -> " + result);
        
        scanner.close();
    }
}

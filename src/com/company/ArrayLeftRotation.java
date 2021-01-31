package com.company;

import java.io.IOException;
import java.util.Scanner;

public class ArrayLeftRotation
{
    
    public static int[] rotLeft(int[] n, int d)
    {
        int l = n.length;
        int[] swap = new int[l];
        for (int i = 0, k = d; i < l; i++, k++)
        {
            if (k <= l - 1)
            {
                swap[i] = n[k];
            }
            if (k == l - 1)
            {
                k = -1;
            }
        }
        return swap;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        
        String[] nd = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nd[0]);
        
        int d = Integer.parseInt(nd[1]);
        
        int[] a = new int[n];
        
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++)
        {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        
        int[] result = rotLeft(a, d);
        
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
            
            if (i != result.length - 1)
            {
                System.out.print(" ");
            }
        }
        
        scanner.close();
    }
}

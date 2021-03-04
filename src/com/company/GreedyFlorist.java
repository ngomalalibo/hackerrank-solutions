package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GreedyFlorist
{
    static int getMinimumCost(int noOfFriends, int[] c)
    {
        Integer[] boxed = new Integer[c.length];
        for (int i = 0; i < c.length; i++)
        {
            boxed[i] = c[i];
        }
        
        Arrays.sort(boxed, Comparator.reverseOrder());
        System.out.println(Arrays.toString(boxed));
        int minimumCost = 0;
        int flowers = boxed.length; // 5
        if (noOfFriends == 0 || flowers == 0)
        {
            return 0;
        }
        if (noOfFriends >= flowers)
        {
            for (int i = flowers - 1; i >= 0; i--)
            {
                minimumCost += boxed[i];
            }
        }
        else
        {
            for (int purchasesMade = 0; purchasesMade < flowers; purchasesMade++)
            {
                minimumCost += boxed[purchasesMade]; // each friend buys one flower
                if (purchasesMade == noOfFriends - 1) // all friends have bought at least one flower
                {
                    int j = 0;
                    while (purchasesMade <= flowers - 2) // each friend buys more if flowers remain
                    {
                        // make purchases
                        if ((purchasesMade + 1) % noOfFriends == 0)
                        {
                            ++j;
                        }
                        minimumCost += boxed[++purchasesMade] * (j + 1);
                    }
                    break;
                }
            }
        }
        return minimumCost;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        String[] nk = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nk[0]);
        
        int k = Integer.parseInt(nk[1]);
        
        int[] c = new int[n];
        
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++)
        {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }
        
        int minimumCost = getMinimumCost(k, c);
        
        System.out.println(minimumCost);
        scanner.close();
    }
}

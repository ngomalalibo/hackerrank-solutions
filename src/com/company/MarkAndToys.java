package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MarkAndToys
{
    static int maximumToys(int[] prices, int k)
    {
        int maxToys = 0;
        int sum = 0;
        Arrays.sort(prices);
        int l = prices.length;
        List<Integer> poss = new ArrayList<>();
        for (int i = 0; i < l; i++)
        {
            if (prices[i] <= k)
            {
                poss.add(prices[i]);
            }
        }
        if (poss.isEmpty())
        {
            return 0;
        }
        l = poss.size();
        for (int i = 0, j = 1; i < l; i++, j++)
        {
            sum += poss.get(i);
            if (sum < k)
            {
                maxToys = j;
            }
            else if (sum == k)
            {
                maxToys = j;
                break;
            }
            else if (i > 0 && sum > k)
            {
                break;
            }
        }
        return maxToys;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        String[] nk = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nk[0]);
        
        int k = Integer.parseInt(nk[1]);
        
        int[] prices = new int[n];
        
        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++)
        {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }
        
        int result = maximumToys(prices, k);
        
        System.out.println(result);
        scanner.close();
    }
}
